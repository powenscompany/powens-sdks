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
 */
@Serializable

data class ExchangeAccessTokenRequest (

    /* Client ID of the application. */
    @SerialName(value = "client_id") @Required val clientId: kotlin.String?,

    /* The client secret associated with the client ID. */
    @SerialName(value = "client_secret") @Required val clientSecret: kotlin.String?

) {

    /**
     * The only accepted (and default) value is `authorization_code`.
     *
     * Values: authorizationCode
     */
    @Serializable
    enum class GrantType(val value: kotlin.String) {
        @SerialName(value = "authorization_code") authorizationCode("authorization_code");
    }
}

