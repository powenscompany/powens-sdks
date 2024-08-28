package com.powens.sdk

import com.powens.sdk.client.WebviewClient
import com.powens.sdk.model.WebviewCallbackResult
import com.powens.sdk.model.WebviewConnectCallbackResult
import com.powens.sdk.model.WebviewManageCallbackResult
import com.powens.sdk.model.WebviewPath
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSNotificationName
import platform.Foundation.NSURL
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
            dispatch_async(dispatch_get_main_queue()) {
                // Dismiss the SFSafariViewController instance
                sourceViewController.dismissViewControllerAnimated(true, null)
            }
        }
    }

    @Throws(IllegalArgumentException::class)
    fun handleConnectCallback(url: NSURL, completionHandler: (result: WebviewConnectCallbackResult) -> Unit) {
        if (!shouldHandleCallback(url, WebviewPath.Connect)) return

        postNotification()

        val callback = WebviewClient.parseConnectCallback(url.query)
        completionHandler(callback)
    }

    @Throws(IllegalArgumentException::class)
    fun handleReconnectCallback(url: NSURL, completionHandler: (result: WebviewCallbackResult) -> Unit) {
        if (!shouldHandleCallback(url, WebviewPath.Reconnect)) return

        postNotification()

        val callback = WebviewClient.parseCallback(url.query)
        completionHandler(callback)
    }

    @Throws(IllegalArgumentException::class)
    fun handleManageCallback(url: NSURL, completionHandler: (result: WebviewManageCallbackResult) -> Unit) {
        if (!shouldHandleCallback(url, WebviewPath.Manage)) return

        postNotification()

        val callback = WebviewClient.parseManageCallback(url.query)
        completionHandler(callback)
    }

    private fun shouldHandleCallback(url: NSURL, path: WebviewPath): Boolean {
        if (url.scheme != WebviewConfig.shared.appScheme) return false
        if (url.host != WebviewConfig.shared.callbackHost) return false
        if (url.path != path.value) return false
        return true
    }

    private fun postNotification() {
        NSNotificationCenter.defaultCenter.postNotificationName(notificationName, this)
    }

}