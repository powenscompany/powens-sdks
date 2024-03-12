# BankAccountsApi

All URIs are relative to *https://demo.biapi.pro/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserAccount**](BankAccountsApi.md#getUserAccount) | **GET** /users/me/accounts/{accountId} | Bank account
[**listUserAccounts**](BankAccountsApi.md#listUserAccounts) | **GET** /users/me/accounts | List bank accounts
[**updateUserAccount**](BankAccountsApi.md#updateUserAccount) | **POST** /users/me/accounts/{accountId} | Update a bank account


<a id="getUserAccount"></a>
# **getUserAccount**
> BankAccount getUserAccount(accountId, all, expand)

Bank account

Get a single bank account of the authenticated user by ID.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = BankAccountsApi()
val accountId : kotlin.Long = 789 // kotlin.Long | Bank account ID.
val all : kotlin.Boolean = true // kotlin.Boolean | Flag to include disabled and deleted items in the list.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : BankAccount = apiInstance.getUserAccount(accountId, all, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BankAccountsApi#getUserAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BankAccountsApi#getUserAccount")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **kotlin.Long**| Bank account ID. |
 **all** | **kotlin.Boolean**| Flag to include disabled and deleted items in the list. | [optional]
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: connection]

### Return type

[**BankAccount**](BankAccount.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listUserAccounts"></a>
# **listUserAccounts**
> BankAccountsList listUserAccounts(all, expand)

List bank accounts

List bank accounts of the authenticated user. By default, only active (not &#x60;deleted&#x60;) accounts are returned, use the &#x60;all&#x60; parameter to get the full list.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = BankAccountsApi()
val all : kotlin.Boolean = true // kotlin.Boolean | Flag to include disabled and deleted items in the list.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : BankAccountsList = apiInstance.listUserAccounts(all, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BankAccountsApi#listUserAccounts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BankAccountsApi#listUserAccounts")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **all** | **kotlin.Boolean**| Flag to include disabled and deleted items in the list. | [optional]
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: connection]

### Return type

[**BankAccountsList**](BankAccountsList.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updateUserAccount"></a>
# **updateUserAccount**
> BankAccount updateUserAccount(accountId, bankAccountUpdateRequest, all, expand)

Update a bank account

Update a bank account. The resource mirrors bank accounts available through the connector, so editing is limited to metadata.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = BankAccountsApi()
val accountId : kotlin.Long = 789 // kotlin.Long | Bank account ID.
val bankAccountUpdateRequest : BankAccountUpdateRequest =  // BankAccountUpdateRequest | 
val all : kotlin.Boolean = true // kotlin.Boolean | Flag to include disabled and deleted items in the list.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : BankAccount = apiInstance.updateUserAccount(accountId, bankAccountUpdateRequest, all, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BankAccountsApi#updateUserAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BankAccountsApi#updateUserAccount")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **kotlin.Long**| Bank account ID. |
 **bankAccountUpdateRequest** | [**BankAccountUpdateRequest**](BankAccountUpdateRequest.md)|  |
 **all** | **kotlin.Boolean**| Flag to include disabled and deleted items in the list. | [optional]
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: connection]

### Return type

[**BankAccount**](BankAccount.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

