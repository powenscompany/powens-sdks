package com.powens.api.model

import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName(
    "ConnectorFieldValue",
    "ConnectorFieldValue",
    true
)
@Serializable
data class ConnectorFieldValue (
    val connectorUuid: String,
    val fieldName: String,
    val value: String
)

@OptIn(ExperimentalObjCName::class)
@ObjCName(
    "WebviewOptions",
    "WebviewOptions",
    true
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

@OptIn(ExperimentalObjCName::class)
@ObjCName(
    "ManageWebviewOptions",
    "ManageWebviewOptions",
    true
)
@Serializable
class ManageWebviewOptions : WebviewOptions() {

}

@OptIn(ExperimentalObjCName::class)
@ObjCName(
    "ConnectWebviewOptions",
    "ConnectWebviewOptions",
    true
)
@Serializable
class ConnectWebviewOptions : WebviewOptions() {
    var maxConnections: Int? = null
    var accountIbans: List<String>? = null
}