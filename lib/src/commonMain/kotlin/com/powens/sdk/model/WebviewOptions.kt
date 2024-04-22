package com.powens.sdk.model

import kotlinx.serialization.Serializable

@Serializable
open class WebviewOptions {
    var connectorUuids: List<String>? = null
    var connectorCapabilities: List<ConnectorCapability>? = null
    var connectorCountry: String? = null
    var connectorFieldValues: Map<String, Map<String, String>>? = null
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