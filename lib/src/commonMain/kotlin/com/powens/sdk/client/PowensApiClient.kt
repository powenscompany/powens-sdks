package com.powens.sdk.client

import com.powens.sdk.client.services.*
import com.powens.sdk.model.ServiceError
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class PowensApiClient
@Throws(IllegalArgumentException::class) constructor(private val root: String, private val clientId: String) {

    companion object {

        @Throws(IllegalArgumentException::class)
        fun forPowensDomain(domain: String, clientId: String): PowensApiClient {
            return PowensApiClient(getPowensDomainRoot(domain), clientId)
        }
    }

    init {
        validateClientId(clientId)
    }

    val auth by lazy {AuthenticationApi(root, null, this::configureClient) }
    val users by lazy { UsersApi(root, null, this::configureClient) }
    val connectors by lazy { ConnectorsApi(root, null, this::configureClient) }
    val connections by lazy { ConnectionsApi(root, null, this::configureClient) }
    val bankAccountTypes by lazy { BankAccountTypesApi(root, null, this::configureClient) }
    val bankAccounts by lazy { BankAccountsApi(root, null, this::configureClient) }
    val bankTransactions by lazy { BankTransactionsApi(root, null, this::configureClient) }

    private fun configureClient(config: HttpClientConfig<*>) {
        config.expectSuccess = true
        config.HttpResponseValidator {
            handleResponseExceptionWithRequest { ex, _ ->
                if (ex is ResponseException) {
                    // Parse body of all errors as ServiceError
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

}