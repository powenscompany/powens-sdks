package com.powens.sdk

import com.powens.sdk.client.WebviewClient
import com.powens.sdk.model.WebviewConnectOptions
import com.powens.sdk.model.WebviewManageOptions
import com.powens.sdk.model.WebviewPath
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
        state: String? = null,
        options: WebviewConnectOptions? = null,
    ): FlowHandle {
        val redirectUri = "${WebviewConfig.shared.redirectUri}${WebviewPath.Connect.value}"
        val url = webviewClient.buildConnectUrl(accessToken, redirectUri, state, options)
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
        state: String? = null,
    ): FlowHandle {
        val redirectUri = "${WebviewConfig.shared.redirectUri}${WebviewPath.Reconnect.value}"
        val url = webviewClient.buildReconnectUrl(connectionId, resetCredentials, accessToken, redirectUri, state)
        return FlowHandle(url)
    }

    @Throws(
        CancellationException::class,
        IllegalArgumentException::class,
    )
    suspend fun manageFlow(
        accessToken: String,
        connectionId: Long? = null,
        state: String? = null,
        options: WebviewManageOptions? = null,
    ): FlowHandle {
        val redirectUri = "${WebviewConfig.shared.redirectUri}${WebviewPath.Manage.value}"
        val url = webviewClient.buildManageUrl(connectionId, accessToken, redirectUri, state, options)
        return FlowHandle(url)
    }

}