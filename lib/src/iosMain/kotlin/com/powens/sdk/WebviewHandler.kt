package com.powens.sdk

import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSNotificationName
import platform.Foundation.NSURL
import platform.Foundation.NSURLComponents
import platform.Foundation.NSURLQueryItem
import platform.UIKit.UIViewController
import platform.darwin.NSObjectProtocol
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

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
            dispatch_async(dispatch_get_main_queue()) {
                sourceViewController.dismissViewControllerAnimated(true, null)
            }
        }
    }

    @Throws(
        IllegalArgumentException::class,
        IllegalStateException::class,
    )
    fun handleWebviewCallback(url: NSURL, completionHandler: (authCode: String?, connectionId: Long?, connectionIds: List<Long>?, error: String?) -> Unit) {
        if (url.scheme != WebviewConfig.shared.appScheme) return
        if (url.host != WebviewConfig.shared.callbackHost) return

        val userInfo: HashMap<String, Any?> = hashMapOf()
        val queryItems = queryItemsFromUrl(url)

        extractErrorCode(queryItems)?.let { userInfo["error"] = it }
        extractAuthCode(queryItems)?.let { userInfo["code"] = it }
        extractConnectionId(queryItems)?.let { userInfo["connection_id"] = it }
        extractConnectionIds(queryItems)?.let { userInfo["connection_ids"] = it }

        NSNotificationCenter.defaultCenter.postNotificationName(
            notificationName,
            this,
            userInfo as Map<Any?, *>
        )

        completionHandler(
            userInfo["code"] as? String,
            userInfo["connection_id"] as? Long,
            userInfo["connection_ids"] as? List<Long>,
            userInfo["error"] as? String
        )
    }

    private fun extractErrorCode(queryItems: List<NSURLQueryItem>?): String? {
        val itemError = queryItems?.firstOrNull { it.name == "error" }
        return itemError?.value
    }

    private fun extractAuthCode(queryItems: List<NSURLQueryItem>?): String? {
        val itemAuthCode = queryItems?.firstOrNull { it.name == "code" }
        return itemAuthCode?.value
    }

    private fun extractConnectionId(queryItems: List<NSURLQueryItem>?): Long? {
        val itemConnectionId = queryItems?.firstOrNull { it.name == "connection_id" }
        val itemIdConnection = queryItems?.firstOrNull { it.name == "id_connection" }
        return (itemConnectionId?.value ?: itemIdConnection?.value)?.toLong()
    }

    private fun extractConnectionIds(queryItems: List<NSURLQueryItem>?): List<Long>? {
        val itemConnectionIds = queryItems?.firstOrNull { it.name == "connection_ids" }
        return itemConnectionIds?.value?.split(",")?.map { it.toLong() }
    }

    private fun queryItemsFromUrl(url: NSURL): List<NSURLQueryItem>? {
        if (url.absoluteString == null) return null
        return NSURLComponents
            .componentsWithString(url.absoluteString!!)
            ?.queryItems as? List<NSURLQueryItem>
    }

}