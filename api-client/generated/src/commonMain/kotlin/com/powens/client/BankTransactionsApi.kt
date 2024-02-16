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

package com.powens.client

import com.powens.api.model.Transaction
import com.powens.api.model.TransactionUpdateRequest
import com.powens.api.model.TransactionsList

import org.openapitools.client.infrastructure.*
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import kotlinx.serialization.json.Json
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

open class BankTransactionsApi(
    baseUrl: String = ApiClient.BASE_URL,
    httpClientEngine: HttpClientEngine? = null,
    httpClientConfig: ((HttpClientConfig<*>) -> Unit)? = null,
    jsonSerializer: Json = ApiClient.JSON_DEFAULT
) : ApiClient(baseUrl, httpClientEngine, httpClientConfig, jsonSerializer) {

    /**
     * Get a bank transaction
     * Get a single bank transaction of the authenticated user by ID.
     * @param transactionId Transaction ID.
     * @param all Flag to include disabled and deleted items in the list. (optional)
     * @param expand  (optional)
     * @return Transaction
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getUserTransaction(transactionId: kotlin.Long, all: kotlin.Boolean? = null, expand: kotlin.collections.List<kotlin.String>? = null): HttpResponse<Transaction> {

        val localVariableAuthNames = listOf<String>("bi_auth")

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        all?.apply { localVariableQuery["all"] = listOf("$all") }
        expand?.apply { localVariableQuery["expand"] = toMultiValue(this, "csv") }
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/users/me/transactions/{transactionId}".replace("{" + "transactionId" + "}", "$transactionId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }


    /**
     * List bank transactions
     * List bank transactions of the authenticated user. By default, only active (not &#x60;deleted&#x60;) transactions are returned, use the &#x60;all&#x60; parameter to get the full list.
     * @param expand  (optional)
     * @param all Flag to include disabled and deleted items in the list. (optional)
     * @param minDate Filter items after the specified date. (optional)
     * @param maxDate Filter items before the specified date. (optional)
     * @param income Filter on incomes or expenditures. (optional)
     * @param deleted Filter on deleted transactions. (optional)
     * @param lastUpdate Filter transactions updated *after* the specified date. (optional)
     * @param wording Filter transactions containing the given string. (optional)
     * @param `value` Value of the transaction. \&quot;XX|-XX\&quot; and \&quot;±XX\&quot; syntaxes are also accepted. (optional)
     * @param search Search in wording, dates, values, categories. (optional)
     * @param offset Return items after the specified offset. (optional, default to 0)
     * @param limit Return at most the specified amount of items. (optional)
     * @return TransactionsList
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun listUserTransactions(expand: kotlin.collections.List<kotlin.String>? = null, all: kotlin.Boolean? = null, minDate: kotlin.String? = null, maxDate: kotlin.String? = null, income: kotlin.Boolean? = null, deleted: kotlin.Boolean? = null, lastUpdate: kotlin.String? = null, wording: kotlin.String? = null, `value`: kotlin.String? = null, search: kotlin.String? = null, offset: kotlin.Double? = 0.toDouble(), limit: kotlin.Double? = null): HttpResponse<TransactionsList> {

        val localVariableAuthNames = listOf<String>("bi_auth")

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        expand?.apply { localVariableQuery["expand"] = toMultiValue(this, "csv") }
        all?.apply { localVariableQuery["all"] = listOf("$all") }
        minDate?.apply { localVariableQuery["min_date"] = listOf("$minDate") }
        maxDate?.apply { localVariableQuery["max_date"] = listOf("$maxDate") }
        income?.apply { localVariableQuery["income"] = listOf("$income") }
        deleted?.apply { localVariableQuery["deleted"] = listOf("$deleted") }
        lastUpdate?.apply { localVariableQuery["last_update"] = listOf("$lastUpdate") }
        wording?.apply { localVariableQuery["wording"] = listOf("$wording") }
        `value`?.apply { localVariableQuery["value"] = listOf("$`value`") }
        search?.apply { localVariableQuery["search"] = listOf("$search") }
        offset?.apply { localVariableQuery["offset"] = listOf("$offset") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/users/me/transactions",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }


    /**
     * Update a bank transaction
     * Update a bank transaction. The resource mirrors bank transactions available through the connector, so editing is limited to metadata.
     * @param transactionId Transaction ID.
     * @param transactionUpdateRequest 
     * @param all Flag to include disabled and deleted items in the list. (optional)
     * @param expand  (optional)
     * @return Transaction
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun updateUserTransaction(transactionId: kotlin.Long, transactionUpdateRequest: TransactionUpdateRequest, all: kotlin.Boolean? = null, expand: kotlin.collections.List<kotlin.String>? = null): HttpResponse<Transaction> {

        val localVariableAuthNames = listOf<String>("bi_auth")

        val localVariableBody = transactionUpdateRequest

        val localVariableQuery = mutableMapOf<String, List<String>>()
        all?.apply { localVariableQuery["all"] = listOf("$all") }
        expand?.apply { localVariableQuery["expand"] = toMultiValue(this, "csv") }
        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.POST,
            "/users/me/transactions/{transactionId}".replace("{" + "transactionId" + "}", "$transactionId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }



}
