package com.powens.api.client

import com.powens.api.model.ConnectWebviewOptions
import com.powens.api.model.ManageWebviewOptions
import com.powens.api.model.WebviewOptions
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
        options: ConnectWebviewOptions? = null
    ): String {
        return this.buildUrl("connect", accessToken, redirectUri) {
            if (options == null) return@buildUrl

            options.maxConnections?.let { append("max_connections", it.toString()) }
            options.accountIbans?.let {
                if (it.isNotEmpty()) append("account_ibans", it.joinToString(","))
            }
            applySharedWebviewOptions(this, options)
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
        options: ManageWebviewOptions? = null
    ): String {
        return this.buildUrl("manage", accessToken, redirectUri) {
            connectionId?.let { append("connection_id", it.toString()) }
            options?.let { applySharedWebviewOptions(this, options) }
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
                authCode?.let { append("code", it) }
                redirectUri?.let { append("redirect_uri", it) }
                paramsBuilder(this)
            }
        }.buildString()
    }

    private fun applySharedWebviewOptions(paramsBuilder: ParametersBuilder, options: WebviewOptions) {
        paramsBuilder.apply {
            options.connectorCountry?.let { append("connector_country", it) }
            options.connectorUuids?.let {
                if (it.isNotEmpty()) append("connector_uuids", it.joinToString(","))
            }
            options.connectorCapabilities?.let {
                if (it.isNotEmpty()) append("connector_capabilities", it.joinToString(","))
            }
            options.accountTypes?.let {
                if (it.isNotEmpty()) append("account_types", it.joinToString(","))
            }
            options.accountUsages?.let {
                if (it.isNotEmpty()) append("account_usages", it.joinToString(","))
            }
            for ((connectorUuid, connectorDict) in options.connectorFieldValues.orEmpty()) {
                for ((fieldName, value) in connectorDict) {
                    append("${connectorUuid}.${fieldName}", value)
                }
            }
        }
    }

}