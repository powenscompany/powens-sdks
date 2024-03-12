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

import com.powens.api.model.ServiceErrorCode

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Common response format for API errors.
 *
 * @param code 
 * @param description A technical description of the error.
 * @param message An optional error message from the connector, intended for end-user display. The message is not translated. 
 */
@Serializable

data class ServiceError1 (

    @SerialName(value = "code") @Required val code: ServiceErrorCode,

    /* A technical description of the error. */
    @SerialName(value = "description") @Required val description: kotlin.String,

    /* An optional error message from the connector, intended for end-user display. The message is not translated.  */
    @SerialName(value = "message") val message: kotlin.String? = null

)

