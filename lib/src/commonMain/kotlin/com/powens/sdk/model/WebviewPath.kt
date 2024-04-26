package com.powens.sdk.model

import kotlinx.serialization.Serializable

@Serializable
enum class WebviewPath(val value: String) {

    Connect("/connect"),

    Reconnect("/reconnect"),

    Manage("/manage"),

}