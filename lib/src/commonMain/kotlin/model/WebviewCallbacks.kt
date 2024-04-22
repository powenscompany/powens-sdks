package com.powens.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed interface WebviewCallbackResult {
    val state: String?
}

sealed interface WebviewConnectCallbackResult {
    val state: String?
}

@Serializable
data class WebviewCallbackSuccess(
    override val state: String?
): WebviewCallbackResult

@Serializable
data class WebviewConnectCallbackSuccess(
    @SerialName("connection_id")
    val connectionId: String,
    @SerialName("connection_ids")
    val connectionIds: List<String>,
    override val state: String?
): WebviewConnectCallbackResult

@Serializable
class WebviewCallbackError(
    @SerialName("error")
    val errorCode: WebviewErrorCode?,
    @SerialName("error_description")
    val errorDescription: String?,
    override val state: String?
): WebviewCallbackResult, WebviewConnectCallbackResult
