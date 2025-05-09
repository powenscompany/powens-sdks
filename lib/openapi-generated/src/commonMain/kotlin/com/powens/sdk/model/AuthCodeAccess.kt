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

/**
 * The type of access granted, `single` or `standard`.
 *
 * Values: Single,Standard
 */
@Serializable
enum class AuthCodeAccess(val value: kotlin.String) {

    @SerialName(value = "single")
    Single("single"),

    @SerialName(value = "standard")
    Standard("standard");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is AuthCodeAccess) "$data" else null

        /**
         * Returns a valid [AuthCodeAccess] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): AuthCodeAccess? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

