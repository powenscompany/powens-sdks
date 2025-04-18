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
@Throws(IllegalArgumentException::class) constructor(private val domain: String, private val clientId: String) {

    companion object {

        private const val WEBVIEW_ROOT = "https://webview.powens.com"

        @Throws(IllegalArgumentException::class)
        fun forPowensDomain(domain: String, clientId: String): WebviewClient {
            return WebviewClient(getPowensDomainRoot(domain), clientId)
        }

        @Throws(IllegalArgumentException::class)
        private fun <R, S : R, E : R> parseCallback(query: String?, success: KSerializer<S>, error: KSerializer<E>): R {
            val paramsTree = JsonObject(parseQueryString(query ?: "").toMap().mapValues { JsonPrimitive(it.value.first()) })
            return Json.decodeFromJsonElement(if (paramsTree.containsKey("error")) error else success, paramsTree)
        }

        @Throws(IllegalArgumentException::class)
        fun parseCallback(query: String?): WebviewCallbackResult =
            parseCallback(query, WebviewCallbackSuccess.serializer(), WebviewCallbackError.serializer())

        @Throws(IllegalArgumentException::class)
        fun parseConnectCallback(query: String?): WebviewConnectCallbackResult =
            parseCallback(query, WebviewConnectCallbackSuccess.serializer(), WebviewCallbackError.serializer())

        @Throws(IllegalArgumentException::class)
        fun parseManageCallback(query: String?): WebviewManageCallbackResult =
            parseCallback(query, WebviewManageCallbackSuccess.serializer(), WebviewCallbackError.serializer())

    }

    init {
        validateClientId(clientId)
    }

    @Throws(
        IllegalArgumentException::class,
        CancellationException::class,
        ServiceException::class,
    )
    suspend fun buildConnectUrl(
        accessToken: String?,
        redirectUri: String,
        state: String? = null,
        options: WebviewConnectOptions? = null
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

    @Throws(
        IllegalArgumentException::class,
        CancellationException::class,
        ServiceException::class,
    )
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

    @Throws(
        IllegalArgumentException::class,
        CancellationException::class,
        ServiceException::class,
    )
    suspend fun buildManageUrl(
        connectionId: Long?,
        accessToken: String,
        redirectUri: String? = null,
        state: String? = null,
        options: WebviewManageOptions? = null
    ): String {
        return this.buildUrl("manage", accessToken, redirectUri, state) {
            connectionId?.let { append("connection_id", it.toString()) }
            options?.let { applySharedWebviewOptions(this, options) }
        }
    }

    @Throws(
        IllegalArgumentException::class,
        CancellationException::class,
        ServiceException::class,
    )
    private suspend fun buildUrl(
        path: String,
        accessToken: String? = null,
        redirectUri: String? = null,
        state: String? = null,
        paramsBuilder: ParametersBuilder.() -> Unit
    ): String {
        val authCode = if (accessToken.isNullOrEmpty()) null
        else PowensApiClient(getPowensDomainRoot(domain), clientId).auth.apply {
            setBearerToken(accessToken)
        }.getAuthCode().body().code
        return URLBuilder(WEBVIEW_ROOT).apply {
            appendPathSegments(path)
            parameters.apply {
                append("domain", domain)
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

    private fun applySharedWebviewOptions(paramsBuilder: ParametersBuilder, options: WebviewOptionsBase) {
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