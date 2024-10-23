package com.powens.sdk

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.powens.sdk.client.WebviewClient
import com.powens.sdk.model.WebviewCallbackError
import com.powens.sdk.model.WebviewConnectCallbackSuccess
import com.powens.sdk.theme.PowensKitTheme
import kotlinx.coroutines.launch

class PowensActivity : ComponentActivity() {

    private val vm by viewModels<ViewModel>()

    private val config
        get() = intent.getParcelableExtraCompat<ConnectConfig>(EXTRA_CONFIG)
            ?: throw IllegalArgumentException("Missing configuration extra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.data?.let {
            val metaData = packageManager.getApplicationInfo(
                packageName,
                PackageManager.GET_META_DATA
            ).metaData
            val clientId = metaData.getString("com.powens.clientId", "").trim()
            if (it.scheme != "powens-${clientId}" || it.path != "callback") return
            try {
                when (val res = WebviewClient.parseConnectCallback(it.query)) {
                    is WebviewConnectCallbackSuccess -> setResult(RESULT_OK, Intent().apply {
                        putExtra("connectionId", res.connectionId)
                    })
                    is WebviewCallbackError -> setResult(RESULT_CANCELED)
                }
                finish()
            } catch (error: IllegalArgumentException) {
                Log.w("PowensActivity", "Invalid webview callback", error)
            }
        }
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
        if (savedInstanceState == null) {
            val metaData = packageManager.getApplicationInfo(
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
            val clientId = metaData.getString("com.powens.clientId", "").trim()
            val redirectUri = "powens-${clientId}://callback"
            val url = WebviewClient.forPowensDomain(domain, clientId).buildConnectUrl(
                config.accessToken,
                redirectUri,
                null,
                config.options
            )
            uiState = uiState.copy(pendingUrl = url)
        }

        fun onUrlOpened() {
            uiState = uiState.copy(pendingUrl = null)
        }

    }

    companion object {

        const val EXTRA_CONFIG = "com.powens.config"
        const val EXTRA_CONNECTION_ID = "com.powens.connectionId"

        fun newConnectIntent(context: Context, config: ConnectConfig) = Intent(context, PowensActivity::class.java)
            .putExtra(PowensActivity.EXTRA_CONFIG, config)

        fun parseConnectResult(resultCode: Int, intent: Intent?): ConnectResult =
            when (resultCode) {
                RESULT_OK -> ConnectResult.Success(connectionId = intent?.getStringExtra(EXTRA_CONNECTION_ID)!!)
                RESULT_CANCELED -> ConnectResult.Error()
                else -> ConnectResult.Error()
            }

    }

}

@Composable
fun MainContent(vm: PowensActivity.ViewModel = PowensActivity.ViewModel()) {
    val webviewLauncher = rememberLauncherForActivityResult(WebviewPresenter().getContract()) {
        Log.d("TAG", "onCreate: Browser dismissed: $it")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        CircularProgressIndicator()
        vm.uiState.pendingUrl?.let {
            SideEffect {
                webviewLauncher.launch(it)
                vm.onUrlOpened()
            }
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