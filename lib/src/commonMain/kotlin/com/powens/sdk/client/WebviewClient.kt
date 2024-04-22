package com.powens.sdk.client

import com.powens.sdk.model.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlin.coroutines.cancellation.CancellationException

class WebviewClient
@Throws(IllegalArgumentException::class) constructor(private val root: String, private val clientId: String) {

    companion object {

        @Throws(IllegalArgumentException::class)
        fun forPowensDomain(domain: String, clientId: String): WebviewClient {
            // Domains must use lowercase letters, digits and hyphens
            require(domain.matches("[a-z\\d]+(-[a-z\\d]+)*".toRegex())) { "Invalid domain" }
            return WebviewClient("https://${domain}.biapi.pro/2.0/", clientId)
        }

        @Throws(IllegalArgumentException::class)
        private fun <R, S : R, E : R> parseCallback(query: String, success: KSerializer<S>, error: KSerializer<E>): R {
            val paramsTree = JsonObject(parseQueryString(query).toMap().mapValues { JsonPrimitive(it.value.first()) })
            return Json.decodeFromJsonElement(if (paramsTree.containsKey("error")) error else success, paramsTree)
        }

        @Throws(IllegalArgumentException::class)
        fun parseCallback(query: String) =
            parseCallback(query, WebviewCallbackSuccess.serializer(), WebviewCallbackError.serializer())

        @Throws(IllegalArgumentException::class)
        fun parseConnectCallback(query: String) =
            parseCallback(query, WebviewConnectCallbackSuccess.serializer(), WebviewCallbackError.serializer())

    }

    init {
        // Client IDs must be digits-only
        require(clientId.matches("\\d+".toRegex())) { "Invalid client ID: $clientId" }
    }

    @Throws(IllegalArgumentException::class, CancellationException::class)
    suspend fun buildConnectUrl(
        accessToken: String?,
        redirectUri: String,
        state: String? = null,
        options: ConnectWebviewOptions? = null
    ): String {
        return this.buildUrl("connect", accessToken, redirectUri, state) {
            if (options == null) return@buildUrl

            options.maxConnections?.let { append("max_connections", it.toString()) }
            options.accountIbans?.let {
                if (it.isNotEmpty()) append("account_ibans", it.joinToString(","))
            }
            applySharedWebviewOptions(this, options)
        }
    }

    @Throws(IllegalArgumentException::class, CancellationException::class)
    suspend fun buildReconnectUrl(
        connectionId: Long,
        resetCredentials: Boolean = false,
        accessToken: String,
        redirectUri: String,
        state: String? = null
    ): String {
        return this.buildUrl("reconnect", accessToken, redirectUri, state) {
            append("connection_id", connectionId.toString())
            if (resetCredentials) append("reset_credentials", "true")
        }
    }

    @Throws(IllegalArgumentException::class, CancellationException::class)
    suspend fun buildManageUrl(
        connectionId: Long?,
        accessToken: String,
        redirectUri: String? = null,
        state: String? = null,
        options: ManageWebviewOptions? = null
    ): String {
        return this.buildUrl("manage", accessToken, redirectUri, state) {
            connectionId?.let { append("connection_id", it.toString()) }
            options?.let { applySharedWebviewOptions(this, options) }
        }
    }

    @Throws(IllegalArgumentException::class, CancellationException::class)
    private suspend fun buildUrl(
        path: String,
        accessToken: String? = null,
        redirectUri: String? = null,
        state: String? = null,
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
                redirectUri?.let {
                    require(Url(it).parameters.isEmpty()) { "Redirect URIs must not contain query parameters" }
                    append("redirect_uri", it)
                }
                state?.let { append("state", it) }
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
            options.connectorFieldValues?.forEach { (uuid, values) ->
                for ((key, value) in values) append("${uuid}.${key}", value)
            }
        }
    }

}