/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.powens.sdk.model

import com.powens.sdk.model.Connector

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * A list of connectors.
 *
 * @param connectors The connectors list.
 */
@Serializable

data class ConnectorsList (

    /* The connectors list. */
    @SerialName(value = "connectors") @Required val connectors: kotlin.collections.List<Connector>

) {


}

