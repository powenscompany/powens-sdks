package com.powens.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface WebviewCallback {
    val state: String?
}

sealed interface WebviewCallbackResult : WebviewCallback
sealed interface WebviewManageCallbackResult : WebviewCallback
sealed interface WebviewConnectCallbackResult : WebviewCallback

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
    val code: String?,
    override val state: String?
): WebviewConnectCallbackResult

@Serializable
data class WebviewManageCallbackSuccess(
    @SerialName("connection_id")
    val connectionId: String?,
    @SerialName("connection_deleted")
    val connectionDeleted: Boolean = false,
    override val state: String?
): WebviewConnectCallbackResult

@Serializable
class WebviewCallbackError(
    @SerialName("error")
    val errorCode: WebviewErrorCode?,
    @SerialName("error_description")
    val errorDescription: String?,
    override val state: String?
): WebviewCallbackResult, WebviewConnectCallbackResult, WebviewManageCallbackResult
