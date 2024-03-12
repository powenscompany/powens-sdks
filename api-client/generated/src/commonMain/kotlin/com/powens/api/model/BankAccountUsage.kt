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

/**
 * Account usage:   * `PRIV`: Private account   * `ORGA`: Professional account   * `ASSO`: Community 
 *
 * Values: Private,Professional,Community
 */
@Serializable
enum class BankAccountUsage(val value: kotlin.String) {

    @SerialName(value = "PRIV")
    Private("PRIV"),

    @SerialName(value = "ORGA")
    Professional("ORGA"),

    @SerialName(value = "ASSO")
    Community("ASSO");

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): kotlin.String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is BankAccountUsage) "$data" else null

        /**
         * Returns a valid [BankAccountUsage] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): BankAccountUsage? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

