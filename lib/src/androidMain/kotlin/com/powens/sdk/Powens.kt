package com.powens.sdk

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.activity.result.contract.ActivityResultContract
import com.powens.sdk.model.WebviewConnectOptions
import kotlinx.parcelize.Parcelize

object Powens {

    fun connectContract(): ActivityResultContract<ConnectConfig, ConnectResult> {
        return object : ActivityResultContract<ConnectConfig, ConnectResult>() {

            override fun createIntent(context: Context, config: ConnectConfig) =
                PowensActivity.newConnectIntent(context, config)

            override fun parseResult(resultCode: Int, intent: Intent?): ConnectResult =
                PowensActivity.parseConnectResult(resultCode, intent)

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