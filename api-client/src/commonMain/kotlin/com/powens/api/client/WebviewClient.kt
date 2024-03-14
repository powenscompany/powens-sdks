package com.powens.api.client

import com.powens.api.model.ConnectorCapability
import io.ktor.http.*

class WebviewClient(private val root: String, private val clientId: String) {

    companion object {

        fun forPowensDomain(domain: String, clientId: String): WebviewClient {
            // Domains must use lowercase letters, digits and hyphens
            require(domain.matches("/[a-z\\d]+(-[a-z\\d]+)*/".toRegex())) { "Invalid domain" }
            return WebviewClient("https://${domain}.biapi.pro/2.0/", clientId)
        }
    }

    init {
        // Client IDs must be digits-only
        require(clientId.matches("\\d+".toRegex())) { "Invalid client ID: $clientId" }
    }

    suspend fun buildConnectUrl(
        accessToken: String,
        redirectUri: String,
        connectorUuids: List<String>? = null,
        connectorCapabilities: List<ConnectorCapability>? = null
    ): String {
        return this.buildUrl(accessToken, "connect", redirectUri) {
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
        accessToken: String,
        connectionId: Long,
        resetCredentials: Boolean = false,
        redirectUri: String
    ): String {
        return this.buildUrl(accessToken, "reconnect", redirectUri) {
            append("connection_id", connectionId.toString())
            if (resetCredentials) append("reset_credentials", "true")
        }
    }

    suspend fun buildManageUrl(
        accessToken: String
    ): String {
        return this.buildUrl(accessToken, "manage") {}
    }

    private suspend fun buildUrl(
        accessToken: String,
        path: String,
        redirectUri: String? = null,
        paramsBuilder: ParametersBuilder.() -> Unit
    ): String {
        val authCode = PowensApiClient(root, "").auth.apply {
            setBearerToken(accessToken)
        }.getAuthCode().body().code
        return URLBuilder(root).apply {
            appendPathSegments("auth", "webview", path)
            parameters.apply {
                append("client_id", clientId)
                append("code", authCode)
                if (redirectUri != null) append("redirect_uri", redirectUri)
                paramsBuilder(this)
            }
        }.buildString()
    }

}