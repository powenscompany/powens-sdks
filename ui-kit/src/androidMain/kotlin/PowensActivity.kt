package com.powens.kit

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.powens.kit.theme.PowensKitTheme
import com.powens.api.client.WebviewClient
import kotlinx.coroutines.launch

class PowensActivity : ComponentActivity() {

    private val vm by viewModels<ViewModel>()

    private val config
        get() = intent.getParcelableExtraCompat<ConnectConfig>(EXTRA_CONFIG)
            ?: throw java.lang.IllegalArgumentException("Missing configuration extra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PowensKitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent(vm)
                }
            }
        }
        val webviewLauncher = registerForActivityResult(WebviewPresenter().getContract()) {
            Log.d("TAG", "onCreate: Browser dismissed: $it")
        }
        if (savedInstanceState == null) {
            val metaData = packageManager.getApplicationInfoCompat(
                packageName,
                PackageManager.GET_META_DATA
            ).metaData
            vm.openConnect(metaData, config)

        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.uiState
            }
        }
    }

    data class State(
        val isLoading: Boolean = false,
        val pendingUrl: String? = null
    )

    class ViewModel : androidx.lifecycle.ViewModel() {

        var uiState by mutableStateOf(State())
            private set

        fun openConnect(metaData: Bundle, config: ConnectConfig) = viewModelScope.launch {
            val domain = metaData.getString("com.powens.domain", "")
            val clientId = metaData.getString("com.powens.clientId", "")
            val redirectUri = "powens-${clientId}://callback"
            val url = WebviewClient.forPowensDomain(domain, clientId).buildConnectUrl(
                config.accessToken,
                redirectUri,
                config.connectorUuids,
                config.connectorCapabilities
            )
            uiState = uiState.copy(pendingUrl = url)
        }

        fun onUrlOpened() {
            uiState = uiState.copy(pendingUrl = null)
        }

    }

    companion object {

        const val EXTRA_CONFIG = "com.powens.config"

    }

}

@Composable
fun MainContent(vm: PowensActivity.ViewModel = PowensActivity.ViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        CircularProgressIndicator()
        vm.uiState.pendingUrl?.let {
            vm.onUrlOpened()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PowensKitTheme {
        MainContent()
    }
}