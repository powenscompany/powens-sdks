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
 * An access token response with medata.
 *
 * @param authToken Access token to use to authenticate calls to the data endpoints.
 * @param type Type of the access token.
 * @param idUser ID of the related user.
 * @param expiresIn Duration in seconds of the token validity. If not specified, the token does not expire.
 */
@Serializable

data class AccessToken (

    /* Access token to use to authenticate calls to the data endpoints. */
    @SerialName(value = "auth_token") @Required val authToken: kotlin.String,

    /* Type of the access token. */
    @SerialName(value = "type") @Required val type: AccessToken.Type,

    /* ID of the related user. */
    @SerialName(value = "id_user") @Required val idUser: kotlin.Long,

    /* Duration in seconds of the token validity. If not specified, the token does not expire. */
    @SerialName(value = "expires_in") val expiresIn: kotlin.Int? = null

) {

    /**
     * Type of the access token.
     *
     * Values: permanent,temporary
     */
    @Serializable
    enum class Type(val value: kotlin.String) {
        @SerialName(value = "permanent") permanent("permanent"),
        @SerialName(value = "temporary") temporary("temporary");
    }
}

