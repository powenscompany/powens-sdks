package com.powens.sdk.model

import com.powens.sdk.infrastructure.Parcelable
import com.powens.sdk.infrastructure.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
open class WebviewOptions : Parcelable {
    var connectorUuids: List<String>? = null
    var connectorCapabilities: List<ConnectorCapability>? = null
    var connectorCountry: String? = null
    var connectorFieldValues: Map<String, Map<String, String>>? = null
    var accountTypes: List<BankAccountTypeName>? = null
    var accountUsages: List<BankAccountUsage>? = null
}

@Serializable
@Parcelize
class WebviewManageOptions : WebviewOptions(), Parcelable

@Serializable
@Parcelize
class WebviewConnectOptions : WebviewOptions(), Parcelable {
    var maxConnections: Int? = null
    var accountIbans: List<String>? = null
}