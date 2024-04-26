package com.powens.sdk.model

import kotlinx.serialization.Serializable

interface WebviewOptions {
    var connectorUuids: List<String>?
    var connectorCapabilities: List<ConnectorCapability>?
    var connectorCountry: String?
    var connectorFieldValues: Map<String, Map<String, String>>?
    var accountTypes: List<BankAccountTypeName>?
    var accountUsages: List<BankAccountUsage>?
}

@Serializable
data class WebviewManageOptions(
    override var connectorUuids: List<String>? = null,
    override var connectorCapabilities: List<ConnectorCapability>? = null,
    override var connectorCountry: String? = null,
    override var connectorFieldValues: Map<String, Map<String, String>>? = null,
    override var accountTypes: List<BankAccountTypeName>? = null,
    override var accountUsages: List<BankAccountUsage>? = null,
) : WebviewOptions {
    constructor() : this(null)
}

@Serializable
data class WebviewConnectOptions(
    override var connectorUuids: List<String>? = null,
    override var connectorCapabilities: List<ConnectorCapability>? = null,
    override var connectorCountry: String? = null,
    override var connectorFieldValues: Map<String, Map<String, String>>? = null,
    override var accountTypes: List<BankAccountTypeName>? = null,
    override var accountUsages: List<BankAccountUsage>? = null,
    var maxConnections: Int? = null,
    var accountIbans: List<String>? = null
) : WebviewOptions {
    constructor() : this(null)
}