package com.powens.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WebviewErrorCode(val value: String) {

    @SerialName(value = "access_denied")
    AccessDenied("access_denied"),

    @SerialName(value = "server_error")
    ServerError("server_error"),

    @SerialName(value = "tos_declined")
    TosDeclined("tos_declined")

}
