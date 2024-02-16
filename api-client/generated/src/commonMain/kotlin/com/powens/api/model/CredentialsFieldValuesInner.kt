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


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param `value` The value to use for the field.
 * @param label The display label associated with the value.
 */
@Serializable

data class CredentialsFieldValuesInner (

    /* The value to use for the field. */
    @SerialName(value = "value") val `value`: kotlin.String? = null,

    /* The display label associated with the value. */
    @SerialName(value = "label") val label: kotlin.String? = null

)

