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
    override val state: String? = null
): WebviewCallbackResult

@Serializable
data class WebviewConnectCallbackSuccess(
    @SerialName("connection_id")
    val connectionId: Long,
    @SerialName("connection_ids")
    val connectionIds: List<Long>? = null,
    val code: String? = null,
    override val state: String? = null
): WebviewConnectCallbackResult

@Serializable
data class WebviewManageCallbackSuccess(
    @SerialName("connection_id")
    val connectionId: Long? = null,
    @SerialName("connection_deleted")
    val connectionDeleted: Boolean = false,
    override val state: String? = null
): WebviewManageCallbackResult

@Serializable
data class WebviewCallbackError(
    @SerialName("error")
    val errorCode: WebviewErrorCode? = null,
    @SerialName("error_description")
    val errorDescription: String? = null,
    override val state: String? = null
): WebviewCallbackResult, WebviewConnectCallbackResult, WebviewManageCallbackResult
