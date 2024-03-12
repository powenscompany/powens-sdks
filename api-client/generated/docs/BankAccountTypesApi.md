# BankAccountTypesApi

All URIs are relative to *https://demo.biapi.pro/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getBankAccountType**](BankAccountTypesApi.md#getBankAccountType) | **GET** /account_types/{typeId} | Bank account type
[**listBankAccountTypes**](BankAccountTypesApi.md#listBankAccountTypes) | **GET** /account_types | List bank account types


<a id="getBankAccountType"></a>
# **getBankAccountType**
> BankAccountType getBankAccountType(typeId)

Bank account type

Get an bank account type by ID.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = BankAccountTypesApi()
val typeId : kotlin.Long = 789 // kotlin.Long | Bank account type ID.
try {
    val result : BankAccountType = apiInstance.getBankAccountType(typeId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BankAccountTypesApi#getBankAccountType")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BankAccountTypesApi#getBankAccountType")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **typeId** | **kotlin.Long**| Bank account type ID. |

### Return type

[**BankAccountType**](BankAccountType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listBankAccountTypes"></a>
# **listBankAccountTypes**
> BankAccountTypesList listBankAccountTypes()

List bank account types

List all bank account types available in the API.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = BankAccountTypesApi()
try {
    val result : BankAccountTypesList = apiInstance.listBankAccountTypes()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BankAccountTypesApi#listBankAccountTypes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BankAccountTypesApi#listBankAccountTypes")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BankAccountTypesList**](BankAccountTypesList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

