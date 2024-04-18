package com.powens.kit

import com.powens.kit.exceptions.ConfigurationException
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSNotificationName
import platform.Foundation.NSURL
import platform.Foundation.NSURLComponents
import platform.Foundation.NSURLQueryItem
import platform.UIKit.UIViewController
import platform.darwin.NSObjectProtocol

object WebviewHandler {
    private val notificationName: NSNotificationName = "PowensWebviewCallback"
    private var observer: NSObjectProtocol? = null

    fun registerWebviewCallback(sourceViewController: UIViewController) {
        if (observer != null) {
            NSNotificationCenter.defaultCenter.removeObserver(observer!!, notificationName, this)
        }

        observer = NSNotificationCenter.defaultCenter.addObserverForName(
            notificationName,
            this,
            null
        ) {
            // Dismiss the SFSafariViewController instance
            sourceViewController.dismissViewControllerAnimated(true, null)
        }
    }

    @Throws(
        ConfigurationException::class,
        IllegalArgumentException::class,
        IllegalStateException::class,
    )
    fun handleWebviewCallback(url: NSURL, completionHandler: (authCode: String?, connectionId: Long?, error: String?) -> Unit) {
        if (url.scheme != WebviewConfig.shared.appScheme) return
        if (url.host != WebviewConfig.shared.callbackHost) return

        val userInfo: HashMap<String, Any?> = hashMapOf()
        if (extractErrorCodeFromCallback(url) != null)
            userInfo["error"] = extractErrorCodeFromCallback(url)
        if (extractAuthCodeFromCallback(url) != null)
            userInfo["code"] = extractAuthCodeFromCallback(url)
        if (extractConnectionIdFromCallback(url) != null)
            userInfo["connection_id"] = extractConnectionIdFromCallback(url)

        NSNotificationCenter.defaultCenter.postNotificationName(
            notificationName,
            this,
            userInfo as Map<Any?, *>
        )

        completionHandler(
            userInfo["code"] as? String,
            userInfo["connection_id"] as? Long,
            userInfo["error"] as? String
        )
    }

    private fun extractErrorCodeFromCallback(url: NSURL): String? {
        val queryItemError = queryItemsFromUrl(url)
            ?.firstOrNull { it.name == "error" }
        return queryItemError?.value
    }

    private fun extractAuthCodeFromCallback(url: NSURL): String? {
        val queryItemAuthCode = queryItemsFromUrl(url)
            ?.firstOrNull { it.name == "code" }
        return queryItemAuthCode?.value
    }

    private fun extractConnectionIdFromCallback(url: NSURL): Long? {
        val queryItemConnectionId = queryItemsFromUrl(url)
            ?.firstOrNull { it.name == "connection_id" }
        val queryItemIdConnection = queryItemsFromUrl(url)
            ?.firstOrNull { it.name == "id_connection" }
        return (queryItemConnectionId?.value ?: queryItemIdConnection?.value)?.toLong()
    }

    private fun queryItemsFromUrl(url: NSURL): List<NSURLQueryItem>? {
        if (url.absoluteString == null) return null
        return NSURLComponents
            .componentsWithString(url.absoluteString!!)
            ?.queryItems as? List<NSURLQueryItem>
    }

}