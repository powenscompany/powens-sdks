package com.powens.api.client

import com.powens.api.model.ConnectorCapability
import io.ktor.http.*
import kotlin.coroutines.cancellation.CancellationException

class WebviewClient(private val root: String, private val clientId: String) {

    companion object {
        @Throws(IllegalArgumentException::class)
        fun forPowensDomain(domain: String, clientId: String): WebviewClient {
            // Domains must use lowercase letters, digits and hyphens
            require(domain.matches("[a-z\\d]+(-[a-z\\d]+)*".toRegex())) { "Invalid domain" }
            return WebviewClient("https://${domain}.biapi.pro/2.0/", clientId)
        }
    }

    init {
        // Client IDs must be digits-only
        require(clientId.matches("\\d+".toRegex())) { "Invalid client ID: $clientId" }
    }

    suspend fun buildConnectUrl(
        accessToken: String?,
        redirectUri: String,
        connectorUuids: List<String>? = null,
        connectorCapabilities: List<ConnectorCapability>? = null
    ): String {
        return this.buildUrl("connect", accessToken, redirectUri) {
            if (!connectorUuids.isNullOrEmpty()) append(
                "connector_uuids",
                connectorUuids.joinToString(",")
            )
            if (!connectorCapabilities.isNullOrEmpty()) append(
                "connector_capabilities",
                connectorCapabilities.joinToString(",")
            )
        }
    }

    suspend fun buildReconnectUrl(
        connectionId: Long,
        accessToken: String,
        redirectUri: String,
        resetCredentials: Boolean = false
    ): String {
        return this.buildUrl("reconnect", accessToken, redirectUri) {
            append("connection_id", connectionId.toString())
            if (resetCredentials) append("reset_credentials", "true")
        }
    }

    suspend fun buildManageUrl(
        connectionId: Long?,
        accessToken: String,
        redirectUri: String? = null,
    ): String {
        return this.buildUrl("manage", accessToken, redirectUri) {
            if (connectionId != null) append("connection_id", connectionId.toString())
        }
    }

    @Throws(
        CancellationException::class,
        ServiceException::class
    )
    private suspend fun buildUrl(
        path: String,
        accessToken: String? = null,
        redirectUri: String? = null,
        paramsBuilder: ParametersBuilder.() -> Unit
    ): String {
        val authCode = if (accessToken.isNullOrEmpty()) null
        else PowensApiClient(root, clientId).auth.apply {
            setBearerToken(accessToken)
        }.getAuthCode().body().code
        return URLBuilder(root).apply {
            appendPathSegments("auth", "webview", path)
            parameters.apply {
                append("client_id", clientId)
                if (authCode != null) append("code", authCode)
                if (redirectUri != null) append("redirect_uri", redirectUri)
                paramsBuilder(this)
            }
        }.buildString()
    }

}