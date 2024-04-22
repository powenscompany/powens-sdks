package com.powens.sdk

import platform.Foundation.NSBundle
import platform.Foundation.NSDictionary
import platform.Foundation.dictionaryWithContentsOfFile

internal class WebviewConfig
    @Throws(IllegalArgumentException::class)
    private constructor() {
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
        require(!infoPlist.isNullOrEmpty()) { "Failed to read Info.plist file" }

        domain = infoPlist["PowensDomain"] as String? ?: ""
        require(domain.isNotEmpty()) { "Invalid domain. Please make sure you have configured the Info.plist file appropriately." }

        val powensUrlScheme = getPowensUrlScheme(infoPlist) ?: ""
        clientId = powensUrlScheme.replace("powens-", "")
        require(clientId.isNotEmpty()) { "Invalid Powens URL scheme. Please make sure you have configured the Info.plist file appropriately." }

        appScheme = powensUrlScheme
        callbackHost = "webview-callback"
        redirectUri = "$appScheme://$callbackHost"
    }

    private fun getInfoPlist(): Map<Any?, *>? {
        val mainBundlePath = NSBundle.mainBundle.pathForResource("Info", "plist")
        return NSDictionary.dictionaryWithContentsOfFile(mainBundlePath ?: "")
    }

    private fun getPowensUrlScheme(infoPlist: Map<Any?, *>): String? {
        val urlTypes = infoPlist[cfBundleUrlTypes] as List<Map<String, List<String>>>?
        val powensSchemeDict = urlTypes?.find { it[cfBundleUrlSchemes]?.first()?.contains("powens-\\d+".toRegex()) ?: false }
        return powensSchemeDict?.get(cfBundleUrlSchemes)?.get(0)
    }

}