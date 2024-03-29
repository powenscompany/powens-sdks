package com.powens.api.client

import com.powens.api.client.services.*
import com.powens.api.infrastructure.ApiClient
import com.powens.api.model.ServiceError
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*

class PowensApiClient(private val root: String, private val clientId: String) {

    val auth by lazy { AuthenticationApi(root, null, this::configureClient, ApiClient.JSON_DEFAULT) }
    val users by lazy { UsersApi(root, null, this::configureClient, ApiClient.JSON_DEFAULT) }
    val connectors by lazy { ConnectorsApi(root, null, this::configureClient, ApiClient.JSON_DEFAULT) }
    val connections by lazy { ConnectionsApi(root, null, this::configureClient, ApiClient.JSON_DEFAULT) }
    val bankAccountTypes by lazy { BankAccountTypesApi(root, null, this::configureClient, ApiClient.JSON_DEFAULT) }
    val bankAccounts by lazy { BankAccountsApi(root, null, this::configureClient, ApiClient.JSON_DEFAULT) }
    val bankTransactions by lazy { BankTransactionsApi(root, null, this::configureClient, ApiClient.JSON_DEFAULT) }

    private fun configureClient(config: HttpClientConfig<*>) {
        config.expectSuccess = true
        config.HttpResponseValidator {
            handleResponseExceptionWithRequest { ex, _ ->
                if (ex is ResponseException) {
                    val apiError = try {
                        ApiClient.JSON_DEFAULT.decodeFromString<ServiceError>(ex.response.bodyAsText())
                    } catch (errorParsingEx: Throwable) {
                        ex.addSuppressed(errorParsingEx)
                        null
                    }
                    throw ServiceException(ex.response.status, apiError, ex)
                }
            }
        }
    }

}