package com.powens.kit

import com.powens.kit.exceptions.ConfigurationException
import platform.Foundation.NSBundle
import platform.Foundation.NSDictionary
import platform.Foundation.NSLog
import platform.Foundation.dictionaryWithContentsOfFile

internal class WebviewConfig {
    private val cfBundleUrlTypes = "CFBundleURLTypes"
    private val cfBundleUrlSchemes = "CFBundleURLSchemes"

    val domain: String
    val clientId: String
    val appScheme: String
    val callbackHost: String
    val redirectUri: String

    companion object {
        val shared: WebviewConfig by lazy {
            WebviewConfig()
        }
    }

    init {
        val infoPlist = getInfoPlist()
        val powensUrlScheme = getPowensUrlScheme(infoPlist)

        domain = infoPlist?.get("PowensDomain") as String
        clientId = powensUrlScheme.replace("powens-", "")
        appScheme = powensUrlScheme
        callbackHost = "webview-callback"
        redirectUri = "$appScheme://$callbackHost"

        if (domain.isNullOrEmpty() || clientId.isNullOrEmpty()) throwConfigError()
    }

    private fun getInfoPlist(): Map<Any?, *>? {
        val mainBundlePath = NSBundle.mainBundle.pathForResource("Info", "plist")
        return NSDictionary.dictionaryWithContentsOfFile(mainBundlePath ?: "")
    }

    private fun getPowensUrlScheme(infoPlist: Map<Any?, *>?): String {
        return ((infoPlist
            ?.get(cfBundleUrlTypes) as List<Map<String, *>>?)
            ?.find {
                (it[cfBundleUrlSchemes] as List<String>?)
                    ?.first()
                    ?.contains("powens-\\d+".toRegex()) ?: false
            }?.get(cfBundleUrlSchemes) as List<String>)[0]
    }

    @Throws(ConfigurationException::class)
    private fun throwConfigError() {
        NSLog("Powens UI SDK could not initialize properly.")
        NSLog("Please make sure you have configured the Info.plist file appropriately.")
        throw ConfigurationException("Powens UI SDK could not initialize properly. Please make sure you have configured the Info.plist file appropriately.")
    }
}