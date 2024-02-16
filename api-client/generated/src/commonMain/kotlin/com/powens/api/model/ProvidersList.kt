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

package com.powens.api.model

import com.powens.api.model.Connector

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * A list of provider connectors.
 *
 * @param providers The connectors list.
 */
@Serializable
@Deprecated(message = "This schema is deprecated.")

data class ProvidersList (

    /* The connectors list. */
    @SerialName(value = "providers") @Required val providers: kotlin.collections.List<Connector>

)

