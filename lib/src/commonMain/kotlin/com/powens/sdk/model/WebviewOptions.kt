package com.powens.sdk.model

import com.powens.sdk.infrastructure.Parcelable
import com.powens.sdk.infrastructure.Parcelize
import kotlinx.serialization.Serializable

interface WebviewOptionsBase {
    var connectorUuids: List<String>?
    var connectorCapabilities: List<ConnectorCapability>?
    var connectorCountry: String?
    var connectorFieldValues: Map<String, Map<String, String>>?
    var accountTypes: List<BankAccountTypeName>?
    var accountUsages: List<BankAccountUsage>?
}

@Serializable
@Parcelize
data class WebviewManageOptions(
     override var connectorUuids: List<String>? = null,
     override var connectorCapabilities: List<ConnectorCapability>? = null,
     override var connectorCountry: String? = null,
     override var connectorFieldValues: Map<String, Map<String, String>>? = null,
     override var accountTypes: List<BankAccountTypeName>? = null,
     override var accountUsages: List<BankAccountUsage>? = null
): WebviewOptionsBase, Parcelable

@Serializable
@Parcelize
data class WebviewConnectOptions(
    override var connectorUuids: List<String>? = null,
    override var connectorCapabilities: List<ConnectorCapability>? = null,
    override var connectorCountry: String? = null,
    override var connectorFieldValues: Map<String, Map<String, String>>? = null,
    override var accountTypes: List<BankAccountTypeName>? = null,
    override var accountUsages: List<BankAccountUsage>? = null,
    var maxConnections: Int? = null,
    var accountIbans: List<String>? = null
) : WebviewOptionsBase, Parcelable