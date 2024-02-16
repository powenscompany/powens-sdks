# BankTransactionsApi

All URIs are relative to *https://demo.biapi.pro/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserTransaction**](BankTransactionsApi.md#getUserTransaction) | **GET** /users/me/transactions/{transactionId} | Get a bank transaction
[**listUserTransactions**](BankTransactionsApi.md#listUserTransactions) | **GET** /users/me/transactions | List bank transactions
[**updateUserTransaction**](BankTransactionsApi.md#updateUserTransaction) | **POST** /users/me/transactions/{transactionId} | Update a bank transaction


<a id="getUserTransaction"></a>
# **getUserTransaction**
> Transaction getUserTransaction(transactionId, all, expand)

Get a bank transaction

Get a single bank transaction of the authenticated user by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = BankTransactionsApi()
val transactionId : kotlin.Long = 789 // kotlin.Long | Transaction ID.
val all : kotlin.Boolean = true // kotlin.Boolean | Flag to include disabled and deleted items in the list.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : Transaction = apiInstance.getUserTransaction(transactionId, all, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BankTransactionsApi#getUserTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BankTransactionsApi#getUserTransaction")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transactionId** | **kotlin.Long**| Transaction ID. |
 **all** | **kotlin.Boolean**| Flag to include disabled and deleted items in the list. | [optional]
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: account, documents]

### Return type

[**Transaction**](Transaction.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listUserTransactions"></a>
# **listUserTransactions**
> TransactionsList listUserTransactions(expand, all, minDate, maxDate, income, deleted, lastUpdate, wording, `value`, search, offset, limit)

List bank transactions

List bank transactions of the authenticated user. By default, only active (not &#x60;deleted&#x60;) transactions are returned, use the &#x60;all&#x60; parameter to get the full list.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = BankTransactionsApi()
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val all : kotlin.Boolean = true // kotlin.Boolean | Flag to include disabled and deleted items in the list.
val minDate : kotlinx.datetime.LocalDate = 2013-10-20 // kotlinx.datetime.LocalDate | Filter items after the specified date.
val maxDate : kotlinx.datetime.LocalDate = 2013-10-20 // kotlinx.datetime.LocalDate | Filter items before the specified date.
val income : kotlin.Boolean = true // kotlin.Boolean | Filter on incomes or expenditures.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Filter on deleted transactions.
val lastUpdate : kotlin.String = lastUpdate_example // kotlin.String | Filter transactions updated *after* the specified date.
val wording : kotlin.String = wording_example // kotlin.String | Filter transactions containing the given string.
val `value` : kotlin.String = `value`_example // kotlin.String | Value of the transaction. \"XX|-XX\" and \"±XX\" syntaxes are also accepted.
val search : kotlin.String = search_example // kotlin.String | Search in wording, dates, values, categories.
val offset : kotlin.Int = 8.14 // kotlin.Int | Return items after the specified offset.
val limit : kotlin.Int = 8.14 // kotlin.Int | Return at most the specified amount of items.
try {
    val result : TransactionsList = apiInstance.listUserTransactions(expand, all, minDate, maxDate, income, deleted, lastUpdate, wording, `value`, search, offset, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BankTransactionsApi#listUserTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BankTransactionsApi#listUserTransactions")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: account, documents]
 **all** | **kotlin.Boolean**| Flag to include disabled and deleted items in the list. | [optional]
 **minDate** | **kotlinx.datetime.LocalDate**| Filter items after the specified date. | [optional]
 **maxDate** | **kotlinx.datetime.LocalDate**| Filter items before the specified date. | [optional]
 **income** | **kotlin.Boolean**| Filter on incomes or expenditures. | [optional]
 **deleted** | **kotlin.Boolean**| Filter on deleted transactions. | [optional]
 **lastUpdate** | **kotlin.String**| Filter transactions updated *after* the specified date. | [optional]
 **wording** | **kotlin.String**| Filter transactions containing the given string. | [optional]
 **&#x60;value&#x60;** | **kotlin.String**| Value of the transaction. \&quot;XX|-XX\&quot; and \&quot;±XX\&quot; syntaxes are also accepted. | [optional]
 **search** | **kotlin.String**| Search in wording, dates, values, categories. | [optional]
 **offset** | **kotlin.Int**| Return items after the specified offset. | [optional]
 **limit** | **kotlin.Int**| Return at most the specified amount of items. | [optional]

### Return type

[**TransactionsList**](TransactionsList.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updateUserTransaction"></a>
# **updateUserTransaction**
> Transaction updateUserTransaction(transactionId, transactionUpdateRequest, all, expand)

Update a bank transaction

Update a bank transaction. The resource mirrors bank transactions available through the connector, so editing is limited to metadata.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = BankTransactionsApi()
val transactionId : kotlin.Long = 789 // kotlin.Long | Transaction ID.
val transactionUpdateRequest : TransactionUpdateRequest =  // TransactionUpdateRequest | 
val all : kotlin.Boolean = true // kotlin.Boolean | Flag to include disabled and deleted items in the list.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : Transaction = apiInstance.updateUserTransaction(transactionId, transactionUpdateRequest, all, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BankTransactionsApi#updateUserTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BankTransactionsApi#updateUserTransaction")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transactionId** | **kotlin.Long**| Transaction ID. |
 **transactionUpdateRequest** | [**TransactionUpdateRequest**](TransactionUpdateRequest.md)|  |
 **all** | **kotlin.Boolean**| Flag to include disabled and deleted items in the list. | [optional]
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: account, documents]

### Return type

[**Transaction**](Transaction.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

