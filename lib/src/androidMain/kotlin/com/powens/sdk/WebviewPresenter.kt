package com.powens.sdk

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract
import androidx.browser.customtabs.CustomTabsIntent.*

class WebviewPresenter(
    private val darkTheme: Boolean? = null
) {

    fun getContract(): ActivityResultContract<String, Int> = CustomTabsContract()

    private inner class CustomTabsContract: ActivityResultContract<String, Int>() {

        override fun createIntent(context: Context, input: String): Intent {
            val intent = Builder()
                .setShowTitle(true)
                .setShareState(SHARE_STATE_OFF)
                .setColorScheme(when (darkTheme) {
                    true -> COLOR_SCHEME_DARK
                    false -> COLOR_SCHEME_LIGHT
                    null -> COLOR_SCHEME_SYSTEM
                })
                .setInstantAppsEnabled(true)
                .build().intent
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.data = Uri.parse(input)
            return intent
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Int {
            return resultCode
        }

    }

}