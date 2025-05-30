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
import com.powens.sdk.model.ConnectorCapability
import com.powens.sdk.model.ConnectorCountry
import com.powens.sdk.model.ConnectorSource
import com.powens.sdk.model.CredentialsField

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * A connector (bank or provider).
 *
 * @param id 
 * @param uuid Unique connector identifier, stable across API domains.
 * @param name Name of the bank or provider.
 * @param charged Whether usage of this connector is charged.
 * @param beta If true, this connector is likely instable.
 * @param capabilities A list of capabilities supported by this connector.
 * @param authMechanism 
 * @param restricted If true, new connections cannot be added with this connector.
 * @param hidden Whether this connector is hidden from users.
 * @param code For bank connectors, the bank code.
 * @param color Branding color of the bank or provider.
 * @param slug A short letter code to identify the connector. Slugs are not unique.
 * @param urls A list of websites associated with the connector.
 * @param syncPeriodicity How many days to wait between syncs.
 * @param monthsToFetch Number of months of history to fetch when synchronizing a connection.
 * @param transferMechanism 
 * @param siret For provider connectors, the SIRET code.
 * @param sources Optional `expand`: The details of the sources available for the connector.
 * @param fields Optional `expand`: The list of initial form fields associated with the connector. Only relevant when building a custom connection integration.
 * @param countries Optional `expand`: Countries where users can open or have accounts/subscriptions with the given institution.
 */
@Serializable

data class Connector (

    @SerialName(value = "id") @Required val id: kotlin.ULong,

    /* Unique connector identifier, stable across API domains. */
    @SerialName(value = "uuid") @Required val uuid: kotlin.String,

    /* Name of the bank or provider. */
    @SerialName(value = "name") @Required val name: kotlin.String,

    /* Whether usage of this connector is charged. */
    @SerialName(value = "charged") @Required val charged: kotlin.Boolean,

    /* If true, this connector is likely instable. */
    @SerialName(value = "beta") @Required val beta: kotlin.Boolean,

    /* A list of capabilities supported by this connector. */
    @SerialName(value = "capabilities") @Required val capabilities: kotlin.collections.Set<ConnectorCapability>,

    @SerialName(value = "auth_mechanism") @Required val authMechanism: AuthMechanism,

    /* If true, new connections cannot be added with this connector. */
    @SerialName(value = "restricted") @Required val restricted: kotlin.Boolean,

    /* Whether this connector is hidden from users. */
    @SerialName(value = "hidden") val hidden: kotlin.Boolean? = null,

    /* For bank connectors, the bank code. */
    @SerialName(value = "code") val code: kotlin.String? = null,

    /* Branding color of the bank or provider. */
    @SerialName(value = "color") val color: kotlin.String? = null,

    /* A short letter code to identify the connector. Slugs are not unique. */
    @SerialName(value = "slug") val slug: kotlin.String? = null,

    /* A list of websites associated with the connector. */
    @SerialName(value = "urls") val urls: kotlin.collections.List<kotlin.String>? = null,

    /* How many days to wait between syncs. */
    @SerialName(value = "sync_periodicity") val syncPeriodicity: kotlin.Float? = null,

    /* Number of months of history to fetch when synchronizing a connection. */
    @SerialName(value = "months_to_fetch") val monthsToFetch: kotlin.Int? = null,

    @SerialName(value = "transfer_mechanism") val transferMechanism: AuthMechanism? = null,

    /* For provider connectors, the SIRET code. */
    @SerialName(value = "siret") val siret: kotlin.String? = null,

    /* Optional `expand`: The details of the sources available for the connector. */
    @SerialName(value = "sources") val sources: kotlin.collections.List<ConnectorSource>? = null,

    /* Optional `expand`: The list of initial form fields associated with the connector. Only relevant when building a custom connection integration. */
    @SerialName(value = "fields") val fields: kotlin.collections.List<CredentialsField>? = null,

    /* Optional `expand`: Countries where users can open or have accounts/subscriptions with the given institution. */
    @SerialName(value = "countries") val countries: kotlin.collections.List<ConnectorCountry>? = null

) {


}

