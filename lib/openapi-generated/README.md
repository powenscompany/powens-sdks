# com.powens.sdk - Kotlin client library for Powens API

An open finance platform. See our [online reference documentation](https://docs.budget-insight.com/reference).


## Overview
This API client was generated by the [OpenAPI Generator](https://openapi-generator.tech) project.  By using the [openapi-spec](https://github.com/OAI/OpenAPI-Specification) from a remote server, you can easily generate an API client.

- API version: 2.0
- Package version: 
- Generator version: 7.9.0
- Build package: org.openapitools.codegen.languages.KotlinClientCodegen

## Requires

* Kotlin 1.5.10

## Build

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.


<a id="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://demo.biapi.pro/2.0*

| Class | Method | HTTP request | Description |
| ------------ | ------------- | ------------- | ------------- |
| *AuthenticationApi* | [**exchangeAccessToken**](docs/AuthenticationApi.md#exchangeaccesstoken) | **POST** /auth/token/access | Exchange a temporary code for a permanent user access token |
| *AuthenticationApi* | [**getAuthCode**](docs/AuthenticationApi.md#getauthcode) | **GET** /auth/token/code | Generate a temporary code |
| *AuthenticationApi* | [**getServiceAccessToken**](docs/AuthenticationApi.md#getserviceaccesstoken) | **POST** /auth/token | Generate a service token |
| *AuthenticationApi* | [**initUserToken**](docs/AuthenticationApi.md#initusertoken) | **POST** /auth/init | Create a new anonymous user |
| *AuthenticationApi* | [**renewAccessToken**](docs/AuthenticationApi.md#renewaccesstoken) | **POST** /auth/renew | Generate a new permanent access token for an existing user |
| *AuthenticationApi* | [**revokeAccessToken**](docs/AuthenticationApi.md#revokeaccesstoken) | **DELETE** /auth/token | Revoke an access token |
| *BankAccountTypesApi* | [**getBankAccountType**](docs/BankAccountTypesApi.md#getbankaccounttype) | **GET** /account_types/{typeId} | Bank account type |
| *BankAccountTypesApi* | [**listBankAccountTypes**](docs/BankAccountTypesApi.md#listbankaccounttypes) | **GET** /account_types | List bank account types |
| *BankAccountsApi* | [**getUserAccount**](docs/BankAccountsApi.md#getuseraccount) | **GET** /users/me/accounts/{accountId} | Bank account |
| *BankAccountsApi* | [**listUserAccounts**](docs/BankAccountsApi.md#listuseraccounts) | **GET** /users/me/accounts | List bank accounts |
| *BankAccountsApi* | [**updateUserAccount**](docs/BankAccountsApi.md#updateuseraccount) | **POST** /users/me/accounts/{accountId} | Update a bank account |
| *BankTransactionsApi* | [**getUserTransaction**](docs/BankTransactionsApi.md#getusertransaction) | **GET** /users/me/transactions/{transactionId} | Get a bank transaction |
| *BankTransactionsApi* | [**listUserTransactions**](docs/BankTransactionsApi.md#listusertransactions) | **GET** /users/me/transactions | List bank transactions |
| *BankTransactionsApi* | [**updateUserTransaction**](docs/BankTransactionsApi.md#updateusertransaction) | **POST** /users/me/transactions/{transactionId} | Update a bank transaction |
| *ConnectionsApi* | [**createUserConnection**](docs/ConnectionsApi.md#createuserconnection) | **POST** /users/me/connections | Add a connection |
| *ConnectionsApi* | [**deleteUserConnection**](docs/ConnectionsApi.md#deleteuserconnection) | **DELETE** /users/me/connections/{connectionId} | Delete a connection |
| *ConnectionsApi* | [**getUserConnection**](docs/ConnectionsApi.md#getuserconnection) | **GET** /users/me/connections/{connectionId} | Connection |
| *ConnectionsApi* | [**listUserConnections**](docs/ConnectionsApi.md#listuserconnections) | **GET** /users/me/connections | List connections |
| *ConnectionsApi* | [**openWebAuth**](docs/ConnectionsApi.md#openwebauth) | **GET** /webauth | Open the connector webview |
| *ConnectionsApi* | [**updateSyncUserConnection**](docs/ConnectionsApi.md#updatesyncuserconnection) | **POST** /users/me/connections/{connectionId} | Update and/or sync a connection |
| *ConnectorsApi* | [**batchEnableConnectorsById**](docs/ConnectorsApi.md#batchenableconnectorsbyid) | **PUT** /connectors/{connectorIds} | Batch enable/disable connectors (deprecated) |
| *ConnectorsApi* | [**getBank**](docs/ConnectorsApi.md#getbank) | **GET** /banks/{connectorId} | Bank connector |
| *ConnectorsApi* | [**getConnector**](docs/ConnectorsApi.md#getconnector) | **GET** /connectors/{connectorId} | Connector |
| *ConnectorsApi* | [**getConnectorByUuid**](docs/ConnectorsApi.md#getconnectorbyuuid) | **GET** /connectors/{connectorUuid} | Connector |
| *ConnectorsApi* | [**getProvider**](docs/ConnectorsApi.md#getprovider) | **GET** /providers/{connectorId} | Get a provider |
| *ConnectorsApi* | [**listBanks**](docs/ConnectorsApi.md#listbanks) | **GET** /banks | List banks |
| *ConnectorsApi* | [**listConnectors**](docs/ConnectorsApi.md#listconnectors) | **GET** /connectors | List connectors |
| *ConnectorsApi* | [**listProviders**](docs/ConnectorsApi.md#listproviders) | **GET** /providers | List providers |
| *ConnectorsApi* | [**updateConnectors**](docs/ConnectorsApi.md#updateconnectors) | **PATCH** /connectors | Batch enable/disable connectors |
| *UsersApi* | [**deleteUser**](docs/UsersApi.md#deleteuser) | **DELETE** /users/me | Delete the authenticated user |
| *UsersApi* | [**getUser**](docs/UsersApi.md#getuser) | **GET** /users/me | Authenticated user |


<a id="documentation-for-models"></a>
## Documentation for Models

 - [com.powens.sdk.model.AccessToken](docs/AccessToken.md)
 - [com.powens.sdk.model.AccessTokenRequest](docs/AccessTokenRequest.md)
 - [com.powens.sdk.model.AccessTokenType](docs/AccessTokenType.md)
 - [com.powens.sdk.model.AccountSchemeName](docs/AccountSchemeName.md)
 - [com.powens.sdk.model.AuthCode](docs/AuthCode.md)
 - [com.powens.sdk.model.AuthCodeAccess](docs/AuthCodeAccess.md)
 - [com.powens.sdk.model.AuthCodeType](docs/AuthCodeType.md)
 - [com.powens.sdk.model.AuthMechanism](docs/AuthMechanism.md)
 - [com.powens.sdk.model.BankAccount](docs/BankAccount.md)
 - [com.powens.sdk.model.BankAccountExpand](docs/BankAccountExpand.md)
 - [com.powens.sdk.model.BankAccountExpandField](docs/BankAccountExpandField.md)
 - [com.powens.sdk.model.BankAccountType](docs/BankAccountType.md)
 - [com.powens.sdk.model.BankAccountTypeName](docs/BankAccountTypeName.md)
 - [com.powens.sdk.model.BankAccountTypesList](docs/BankAccountTypesList.md)
 - [com.powens.sdk.model.BankAccountUpdateRequest](docs/BankAccountUpdateRequest.md)
 - [com.powens.sdk.model.BankAccountUsage](docs/BankAccountUsage.md)
 - [com.powens.sdk.model.BankAccountsList](docs/BankAccountsList.md)
 - [com.powens.sdk.model.BanksList](docs/BanksList.md)
 - [com.powens.sdk.model.CalendarBound](docs/CalendarBound.md)
 - [com.powens.sdk.model.Connection](docs/Connection.md)
 - [com.powens.sdk.model.ConnectionExpand](docs/ConnectionExpand.md)
 - [com.powens.sdk.model.ConnectionExpandField](docs/ConnectionExpandField.md)
 - [com.powens.sdk.model.ConnectionRequest](docs/ConnectionRequest.md)
 - [com.powens.sdk.model.ConnectionSource](docs/ConnectionSource.md)
 - [com.powens.sdk.model.ConnectionState](docs/ConnectionState.md)
 - [com.powens.sdk.model.ConnectionUpdateRequest](docs/ConnectionUpdateRequest.md)
 - [com.powens.sdk.model.ConnectionsList](docs/ConnectionsList.md)
 - [com.powens.sdk.model.Connector](docs/Connector.md)
 - [com.powens.sdk.model.ConnectorCapability](docs/ConnectorCapability.md)
 - [com.powens.sdk.model.ConnectorCountry](docs/ConnectorCountry.md)
 - [com.powens.sdk.model.ConnectorExpand](docs/ConnectorExpand.md)
 - [com.powens.sdk.model.ConnectorExpandField](docs/ConnectorExpandField.md)
 - [com.powens.sdk.model.ConnectorPatch](docs/ConnectorPatch.md)
 - [com.powens.sdk.model.ConnectorSource](docs/ConnectorSource.md)
 - [com.powens.sdk.model.ConnectorsList](docs/ConnectorsList.md)
 - [com.powens.sdk.model.CredentialsField](docs/CredentialsField.md)
 - [com.powens.sdk.model.CredentialsFieldType](docs/CredentialsFieldType.md)
 - [com.powens.sdk.model.CredentialsFieldValue](docs/CredentialsFieldValue.md)
 - [com.powens.sdk.model.Currency](docs/Currency.md)
 - [com.powens.sdk.model.DateBoundedList](docs/DateBoundedList.md)
 - [com.powens.sdk.model.ExchangeAccessToken](docs/ExchangeAccessToken.md)
 - [com.powens.sdk.model.ExchangeAccessTokenRequest](docs/ExchangeAccessTokenRequest.md)
 - [com.powens.sdk.model.Loan](docs/Loan.md)
 - [com.powens.sdk.model.LoanType](docs/LoanType.md)
 - [com.powens.sdk.model.ProvidersList](docs/ProvidersList.md)
 - [com.powens.sdk.model.RenewAccessTokenRequest](docs/RenewAccessTokenRequest.md)
 - [com.powens.sdk.model.ServiceAccessToken](docs/ServiceAccessToken.md)
 - [com.powens.sdk.model.ServiceAccessTokenRequest](docs/ServiceAccessTokenRequest.md)
 - [com.powens.sdk.model.ServiceError](docs/ServiceError.md)
 - [com.powens.sdk.model.ServiceError1](docs/ServiceError1.md)
 - [com.powens.sdk.model.ServiceErrorCode](docs/ServiceErrorCode.md)
 - [com.powens.sdk.model.ServiceTokenScope](docs/ServiceTokenScope.md)
 - [com.powens.sdk.model.Transaction](docs/Transaction.md)
 - [com.powens.sdk.model.TransactionCounterparty](docs/TransactionCounterparty.md)
 - [com.powens.sdk.model.TransactionCounterpartyType](docs/TransactionCounterpartyType.md)
 - [com.powens.sdk.model.TransactionType](docs/TransactionType.md)
 - [com.powens.sdk.model.TransactionUpdateRequest](docs/TransactionUpdateRequest.md)
 - [com.powens.sdk.model.TransactionValueFilter](docs/TransactionValueFilter.md)
 - [com.powens.sdk.model.TransactionsList](docs/TransactionsList.md)
 - [com.powens.sdk.model.User](docs/User.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="bearerAuth"></a>
### bearerAuth

- **Type**: HTTP Bearer Token authentication



## Author

contact@budget-insight.com
