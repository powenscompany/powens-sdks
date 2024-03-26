package com.powens.api.client

import com.powens.api.client.services.*
import com.powens.api.model.ServiceError
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class PowensApiClient(private val root: String, private val clientId: String) {

    private val httpClient = HttpClient {
        expectSuccess = true
        HttpResponseValidator {
            handleResponseExceptionWithRequest { ex, _ ->
                if (ex is ResponseException) {
                    val apiError = try {
                        Json.decodeFromString<ServiceError>(ex.response.bodyAsText())
                    } catch (errorParsingEx: Throwable) {
                        ex.addSuppressed(errorParsingEx)
                        null
                    }
                    throw ServiceException(ex.response.status, apiError, ex)
                }
            }
        }
    }

    val auth by lazy { AuthenticationApi(root, httpClient) }
    val users by lazy { UsersApi(root, httpClient) }
    val connectors by lazy { ConnectorsApi(root, httpClient) }
    val connections by lazy { ConnectionsApi(root, httpClient) }
    val bankAccountTypes by lazy { BankAccountTypesApi(root, httpClient) }
    val bankAccounts by lazy { BankAccountsApi(root, httpClient) }
    val bankTransactions by lazy { BankTransactionsApi(root, httpClient) }

}