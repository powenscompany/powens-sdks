package com.powens.kit

import com.powens.api.client.WebviewClient
import com.powens.api.model.ConnectWebviewOptions
import com.powens.api.model.ManageWebviewOptions
import platform.Foundation.NSURL
import platform.SafariServices.SFSafariViewController
import platform.SafariServices.SFSafariViewControllerDismissButtonStyle
import platform.UIKit.UIViewController
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.cancellation.CancellationException

class FlowHandle
    internal constructor(private val url: String) {
    fun presentOn(sourceViewController: UIViewController) {
        val sfSafariVC = SFSafariViewController(NSURL.URLWithString(url)!!)
        sfSafariVC.dismissButtonStyle = SFSafariViewControllerDismissButtonStyle.SFSafariViewControllerDismissButtonStyleClose
        dispatch_async(dispatch_get_main_queue()) {
            sourceViewController.presentViewController(sfSafariVC, true, null)
        }
    }
}

object WebviewLauncher {
    private val webviewClient by lazy {
        WebviewClient.forPowensDomain(WebviewConfig.shared.domain, WebviewConfig.shared.clientId)
    }

    @Throws(
        CancellationException::class,
        IllegalArgumentException::class,
    )
    suspend fun connectFlow(
        accessToken: String? = null,
        options: ConnectWebviewOptions? = null,
    ): FlowHandle {
        val url = webviewClient.buildConnectUrl(accessToken, WebviewConfig.shared.redirectUri, options)
        return FlowHandle(url)
    }

    @Throws(
        CancellationException::class,
        IllegalArgumentException::class,
    )
    suspend fun reconnectFlow(
        accessToken: String,
        connectionId: Long,
        resetCredentials: Boolean = false,
    ): FlowHandle {
        val url = webviewClient.buildReconnectUrl(connectionId, accessToken, WebviewConfig.shared.redirectUri, resetCredentials)
        return FlowHandle(url)
    }

    @Throws(
        CancellationException::class,
        IllegalArgumentException::class,
    )
    suspend fun manageFlow(
        accessToken: String,
        connectionId: Long? = null,
        options: ManageWebviewOptions? = null,
    ): FlowHandle {
        val url = webviewClient.buildManageUrl(connectionId, accessToken, WebviewConfig.shared.redirectUri, options)
        return FlowHandle(url)
    }

}