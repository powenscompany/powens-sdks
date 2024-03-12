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

import com.powens.api.model.BankAccountTypeName
import com.powens.api.model.Connection
import com.powens.api.model.Currency
import com.powens.api.model.Loan
import com.powens.api.model.MonetaryValue

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * A bank account.
 *
 * @param id 
 * @param connectionId 
 * @param userId 
 * @param idSource 
 * @param originalName Original name of the account, as exposed on the connector API or website.
 * @param type 
 * @param idType 
 * @param parentId 
 * @param balance The balance of the bank account.
 * @param coming Amount of coming operations not yet debited.
 * @param currency 
 * @param lastUpdate Last successful update of the account.
 * @param deleted If set, this account is not found on the website anymore.
 * @param disabled If set, this account has been disabled by user and will not be synchronized.
 * @param number The bank account number, if available.
 * @param iban The bank account IBAN, if available.
 * @param loan 
 * @param connection 
 */
@Serializable

data class BankAccount (

    @SerialName(value = "id") @Required val id: kotlin.Long,

    @SerialName(value = "id_connection") @Required val connectionId: kotlin.Long,

    @SerialName(value = "id_user") @Required val userId: kotlin.Long,

    @SerialName(value = "id_source") @Required val idSource: kotlin.Long,

    /* Original name of the account, as exposed on the connector API or website. */
    @SerialName(value = "original_name") @Required val originalName: kotlin.String,

    @SerialName(value = "type") @Required val type: BankAccountTypeName,

    @SerialName(value = "id_type") @Required val idType: kotlin.Long,

    @SerialName(value = "id_parent") val parentId: kotlin.Long? = null,

    /* The balance of the bank account. */
    @SerialName(value = "balance") val balance: MonetaryValue? = null,

    /* Amount of coming operations not yet debited. */
    @SerialName(value = "coming") val coming: MonetaryValue? = null,

    @SerialName(value = "currency") val currency: Currency? = null,

    /* Last successful update of the account. */
    @SerialName(value = "last_update") val lastUpdate: kotlinx.datetime.LocalDateTime? = null,

    /* If set, this account is not found on the website anymore. */
    @SerialName(value = "deleted") val deleted: kotlinx.datetime.LocalDateTime? = null,

    /* If set, this account has been disabled by user and will not be synchronized. */
    @SerialName(value = "disabled") val disabled: kotlinx.datetime.LocalDateTime? = null,

    /* The bank account number, if available. */
    @SerialName(value = "number") val number: kotlin.String? = null,

    /* The bank account IBAN, if available. */
    @SerialName(value = "iban") val iban: kotlin.String? = null,

    @SerialName(value = "loan") val loan: Loan? = null,

    @SerialName(value = "connection") val connection: Connection? = null

)

