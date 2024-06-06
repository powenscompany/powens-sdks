package com.powens.sdk

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.activity.result.contract.ActivityResultContract
import com.powens.sdk.model.WebviewConnectOptions
import com.powens.sdk.infrastructure.Parcelize

object Powens {

    fun connectContract(): ActivityResultContract<ConnectConfig, ConnectResult> {
        return object : ActivityResultContract<ConnectConfig, ConnectResult>() {

            override fun createIntent(context: Context, input: ConnectConfig) =
                Intent(context, PowensActivity::class.java)
                    .putExtra(PowensActivity.EXTRA_CONFIG, input)

            override fun parseResult(resultCode: Int, intent: Intent?): ConnectResult =
                when (resultCode) {
                    Activity.RESULT_OK -> ConnectResult.Success(intent?.getStringExtra("connectionId")!!)
                    Activity.RESULT_CANCELED -> ConnectResult.Error()
                    else -> ConnectResult.Error()
                }

        }
    }

}

@Parcelize
data class ConnectConfig(
    val accessToken: String,
    val options: WebviewConnectOptions? = null,
    val themeDark: Boolean? = null,
    val themeDynamicColor: Boolean = true,
    val themePrimaryColor: Int? = null
): Parcelable

sealed class ConnectResult() {
    data class Success(val connectionId: String): ConnectResult()
    class Error: ConnectResult()
}