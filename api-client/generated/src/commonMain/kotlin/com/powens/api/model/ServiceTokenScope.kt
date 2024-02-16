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
 * The possible scopes are: * `payments:admin`: Grants all rights on payments. * `payments:read-only`: Only GET requests are allowed on payments. * `payments:allow-sensitive`: Grants read access on sensitive information for payments. * `payments:validate`: Allows to execute payments. * `payments:cancel`: Allows to submit payment cancellation requests. * ~~`payments`~~ (deprecated):  Alias for `payments:admin`. 
 *
 * Values: paymentsColonAdmin,paymentsColonReadMinusOnly,paymentsColonAllowMinusSensitive,paymentsColonValidate,paymentsColonCancel,payments
 */
@Serializable
enum class ServiceTokenScope(val value: kotlin.String) {

    @SerialName(value = "payments:admin")
    paymentsColonAdmin("payments:admin"),

    @SerialName(value = "payments:read-only")
    paymentsColonReadMinusOnly("payments:read-only"),

    @SerialName(value = "payments:allow-sensitive")
    paymentsColonAllowMinusSensitive("payments:allow-sensitive"),

    @SerialName(value = "payments:validate")
    paymentsColonValidate("payments:validate"),

    @SerialName(value = "payments:cancel")
    paymentsColonCancel("payments:cancel"),

    @SerialName(value = "payments")
    payments("payments");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is ServiceTokenScope) "$data" else null

        /**
         * Returns a valid [ServiceTokenScope] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): ServiceTokenScope? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

