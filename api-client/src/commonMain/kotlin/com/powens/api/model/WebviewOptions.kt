package com.powens.api.model

import kotlinx.serialization.Serializable

@Serializable
data class ConnectorFieldValue (
    val connectorUuid: String,
    val fieldName: String,
    val value: String
)

@Serializable
open class WebviewOptions {
    var connectorUuids: List<String>? = null
    var connectorCapabilities: List<ConnectorCapability>? = null
    var connectorCountry: String? = null
    var connectorFieldValues: List<ConnectorFieldValue>? = null
    var accountTypes: List<BankAccountTypeName>? = null
    var accountUsages: List<BankAccountUsage>? = null
}

@Serializable
class ManageWebviewOptions : WebviewOptions() {

}

@Serializable
class ConnectWebviewOptions : WebviewOptions() {
    var maxConnections: Int? = null
    var accountIbans: List<String>? = null
}