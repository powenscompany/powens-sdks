package com.powens.kit

import com.powens.api.client.WebviewClient
import com.powens.api.model.ConnectWebviewOptions
import com.powens.api.model.ManageWebviewOptions
import com.powens.kit.exceptions.ConfigurationException
import platform.Foundation.NSLog
import platform.Foundation.NSURL
import platform.SafariServices.SFSafariViewController
import platform.SafariServices.SFSafariViewControllerDismissButtonStyle
import platform.UIKit.UIViewController
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

class WebviewLauncher
    @Throws(
        ConfigurationException::class,
        IllegalArgumentException::class,
    )
    private constructor() {
    private val config = WebviewConfig.shared
    private val webviewClient = WebviewClient.forPowensDomain(config.domain, config.clientId)

    companion object {
        val shared: WebviewLauncher by lazy {
            WebviewLauncher()
        }
    }

    suspend fun presentConnectWebview(
        sourceViewController: UIViewController,
        accessToken: String? = null,
        options: ConnectWebviewOptions? = null
    ) {
        val url = webviewClient.buildConnectUrl(accessToken, config.redirectUri, options)
        presentSFSafariViewController(sourceViewController, url)
    }

    suspend fun presentReconnectWebview(
        sourceViewController: UIViewController,
        accessToken: String,
        connectionId: Long,
        resetCredentials: Boolean = false
    ) {
        val url = webviewClient.buildReconnectUrl(connectionId, accessToken, config.redirectUri, resetCredentials)
        presentSFSafariViewController(sourceViewController, url)
    }

    suspend fun presentManageWebview(
        sourceViewController: UIViewController,
        accessToken: String,
        connectionId: Long? = null,
        options: ManageWebviewOptions? = null
    ) {
        val url = webviewClient.buildManageUrl(connectionId, accessToken, config.redirectUri, options)
        presentSFSafariViewController(sourceViewController, url)
    }

    @Throws(Exception::class)
    private fun presentSFSafariViewController(sourceViewController: UIViewController, url: String) {
        NSURL.URLWithString(url)?.also { nsUrl ->
            val sfSafariVC = SFSafariViewController(nsUrl)
            sfSafariVC.dismissButtonStyle = SFSafariViewControllerDismissButtonStyle.SFSafariViewControllerDismissButtonStyleClose
            dispatch_async(dispatch_get_main_queue()) {
                sourceViewController.presentViewController(sfSafariVC, true, null)
            }
        } ?: run {
            NSLog("Powens UI SDK failed to initialize the Webview NSURL instance")
            NSLog(url)
            throw Exception("Powens UI SDK failed to initialize the Webview NSURL instance")
        }
    }
}