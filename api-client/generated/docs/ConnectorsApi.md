# ConnectorsApi

All URIs are relative to *https://demo.biapi.pro/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**batchEnableConnectorsById**](ConnectorsApi.md#batchEnableConnectorsById) | **PUT** /connectors/{connectorIds} | Batch enable/disable connectors (deprecated)
[**getBank**](ConnectorsApi.md#getBank) | **GET** /banks/{connectorId} | Bank connector
[**getConnector**](ConnectorsApi.md#getConnector) | **GET** /connectors/{connectorId} | Connector
[**getConnectorByUuid**](ConnectorsApi.md#getConnectorByUuid) | **GET** /connectors/{connectorUuid} | Connector
[**getProvider**](ConnectorsApi.md#getProvider) | **GET** /providers/{connectorId} | Get a provider
[**listBanks**](ConnectorsApi.md#listBanks) | **GET** /banks | List banks
[**listConnectors**](ConnectorsApi.md#listConnectors) | **GET** /connectors | List connectors
[**listProviders**](ConnectorsApi.md#listProviders) | **GET** /providers | List providers
[**updateConnectors**](ConnectorsApi.md#updateConnectors) | **PATCH** /connectors | Batch enable/disable connectors


<a id="batchEnableConnectorsById"></a>
# **batchEnableConnectorsById**
> ConnectorsList batchEnableConnectorsById(connectorIds, expand)

Batch enable/disable connectors (deprecated)

Enable or disable a list of connectors by IDs in a single operation.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val connectorIds : kotlin.collections.List<kotlin.Long> =  // kotlin.collections.List<kotlin.Long> | Connector IDs.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : ConnectorsList = apiInstance.batchEnableConnectorsById(connectorIds, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#batchEnableConnectorsById")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#batchEnableConnectorsById")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectorIds** | [**kotlin.collections.List&lt;kotlin.Long&gt;**](kotlin.Long.md)| Connector IDs. |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**ConnectorsList**](ConnectorsList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getBank"></a>
# **getBank**
> Connector getBank(connectorId, expand)

Bank connector

Get a single bank connector by ID. Use &#x60;/connectors/{id}&#x60; instead.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val connectorId : kotlin.Long = 789 // kotlin.Long | Connector ID.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : Connector = apiInstance.getBank(connectorId, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#getBank")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#getBank")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectorId** | **kotlin.Long**| Connector ID. |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**Connector**](Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getConnector"></a>
# **getConnector**
> Connector getConnector(connectorId, expand)

Connector

Get a single connector by ID.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val connectorId : kotlin.Long = 789 // kotlin.Long | Connector ID.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : Connector = apiInstance.getConnector(connectorId, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#getConnector")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#getConnector")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectorId** | **kotlin.Long**| Connector ID. |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**Connector**](Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getConnectorByUuid"></a>
# **getConnectorByUuid**
> Connector getConnectorByUuid(connectorUuid, expand)

Connector

Get a single connector by UUID.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val connectorUuid : kotlin.String = 38400000-8cf0-11bd-b23e-10b96e4ef00d // kotlin.String | Connector UUID.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : Connector = apiInstance.getConnectorByUuid(connectorUuid, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#getConnectorByUuid")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#getConnectorByUuid")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectorUuid** | **kotlin.String**| Connector UUID. |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**Connector**](Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getProvider"></a>
# **getProvider**
> Connector getProvider(connectorId, expand)

Get a provider

Get a single provider connector by ID. Use &#x60;/connectors/{id}&#x60; instead.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val connectorId : kotlin.Long = 789 // kotlin.Long | Connector ID.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : Connector = apiInstance.getProvider(connectorId, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#getProvider")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#getProvider")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectorId** | **kotlin.Long**| Connector ID. |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**Connector**](Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listBanks"></a>
# **listBanks**
> BanksList listBanks(expand)

List banks

List connectors with the &#x60;bank&#x60; capability. &#x60;Use /connectors&#x60; instead.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : BanksList = apiInstance.listBanks(expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#listBanks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#listBanks")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**BanksList**](BanksList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listConnectors"></a>
# **listConnectors**
> ConnectorsList listConnectors(expand)

List connectors

List all connectors available on a domain. By default, only connectors not &#x60;hidden&#x60; are returned.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : ConnectorsList = apiInstance.listConnectors(expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#listConnectors")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#listConnectors")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**ConnectorsList**](ConnectorsList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listProviders"></a>
# **listProviders**
> ProvidersList listProviders(expand)

List providers

List connectors with the &#x60;document&#x60; capability. &#x60;Use /connectors&#x60; instead.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : ProvidersList = apiInstance.listProviders(expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#listProviders")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#listProviders")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**ProvidersList**](ProvidersList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updateConnectors"></a>
# **updateConnectors**
> ConnectorsList updateConnectors(requestBody, expand)

Batch enable/disable connectors

Enable or disable a list of connectors by UUID in a single operation.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectorsApi()
val requestBody : kotlin.collections.Map<kotlin.String, ConnectorPatch> =  // kotlin.collections.Map<kotlin.String, ConnectorPatch> | 
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : ConnectorsList = apiInstance.updateConnectors(requestBody, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectorsApi#updateConnectors")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectorsApi#updateConnectors")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestBody** | [**kotlin.collections.Map&lt;kotlin.String, ConnectorPatch&gt;**](ConnectorPatch.md)|  |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: fields, sources, countries]

### Return type

[**ConnectorsList**](ConnectorsList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

