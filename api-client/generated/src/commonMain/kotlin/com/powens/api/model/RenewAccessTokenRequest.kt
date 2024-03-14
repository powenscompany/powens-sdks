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
 * @param clientId Client ID of the application.
 * @param clientSecret The client secret associated with the client ID.
 * @param grantType The only accepted value is `client_credentials`.
 * @param userId 
 * @param revokePrevious If true, all other permanent tokens for the user will be deleted. The default is false.
 */
@Serializable

data class RenewAccessTokenRequest (

    /* Client ID of the application. */
    @SerialName(value = "client_id") @Required val clientId: kotlin.String?,

    /* The client secret associated with the client ID. */
    @SerialName(value = "client_secret") @Required val clientSecret: kotlin.String?,

    /* The only accepted value is `client_credentials`. */
    @SerialName(value = "grant_type") @Required val grantType: RenewAccessTokenRequest.GrantType,

    @SerialName(value = "id_user") val userId: kotlin.Long? = null,

    /* If true, all other permanent tokens for the user will be deleted. The default is false. */
    @SerialName(value = "revoke_previous") val revokePrevious: kotlin.Boolean? = null

) {

    /**
     * The only accepted value is `client_credentials`.
     *
     * Values: ClientCredentials
     */
    @Serializable
    enum class GrantType(val value: kotlin.String) {
        @SerialName(value = "client_credentials") ClientCredentials("client_credentials");
    }
}

