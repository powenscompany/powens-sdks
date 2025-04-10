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


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Metadata of a currency.
 *
 * @param id The ISO 4217 code of the currency.
 * @param name Display name of the currency.
 * @param symbol Display symbol of the currency.
 * @param precision Decimal precision of the currency.
 */
@Serializable

data class Currency (

    /* The ISO 4217 code of the currency. */
    @SerialName(value = "id") @Required val id: kotlin.String,

    /* Display name of the currency. */
    @SerialName(value = "name") @Required val name: kotlin.String,

    /* Display symbol of the currency. */
    @SerialName(value = "symbol") @Required val symbol: kotlin.String,

    /* Decimal precision of the currency. */
    @SerialName(value = "precision") @Required val precision: kotlin.Int

) {


}

