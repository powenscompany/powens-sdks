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

import com.powens.sdk.model.AuthMechanism
import com.powens.sdk.model.CredentialsFieldType
import com.powens.sdk.model.CredentialsFieldValue

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param name Technical name of the field.
 * @param type 
 * @param authMechanisms The list of the authentication mechanisms associated with this field.
 * @param label A short display label for the field.
 * @param required Whether posting the field value is required when creating or updating the connection.
 * @param description A longer help text for the field.
 * @param regex An optional regular expression that the value must match.
 * @param propertyValues For `list` fields, the possible values.
 */
@Serializable

data class CredentialsField (

    /* Technical name of the field. */
    @SerialName(value = "name") @Required val name: kotlin.String,

    @SerialName(value = "type") @Required val type: CredentialsFieldType,

    /* The list of the authentication mechanisms associated with this field. */
    @SerialName(value = "auth_mechanisms") @Required val authMechanisms: kotlin.collections.Set<AuthMechanism>,

    /* A short display label for the field. */
    @SerialName(value = "label") @Required val label: kotlin.String,

    /* Whether posting the field value is required when creating or updating the connection. */
    @SerialName(value = "required") @Required val required: kotlin.Boolean,

    /* A longer help text for the field. */
    @SerialName(value = "description") val description: kotlin.String? = null,

    /* An optional regular expression that the value must match. */
    @SerialName(value = "regex") val regex: kotlin.String? = null,

    /* For `list` fields, the possible values. */
    @SerialName(value = "values") val propertyValues: kotlin.collections.List<CredentialsFieldValue>? = null

) {


}

