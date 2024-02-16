# ConnectionsApi

All URIs are relative to *https://demo.biapi.pro/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUserConnection**](ConnectionsApi.md#createUserConnection) | **POST** /users/me/connections | Add a connection
[**deleteUserConnection**](ConnectionsApi.md#deleteUserConnection) | **DELETE** /users/me/connections/{connectionId} | Delete a connection
[**getUserConnection**](ConnectionsApi.md#getUserConnection) | **GET** /users/me/connections/{connectionId} | Connection
[**listUserConnections**](ConnectionsApi.md#listUserConnections) | **GET** /users/me/connections | List connections
[**openWebauth**](ConnectionsApi.md#openWebauth) | **GET** /webauth | Open the connector webview
[**updateSyncUserConnection**](ConnectionsApi.md#updateSyncUserConnection) | **POST** /users/me/connections/{connectionId} | Update and/or sync a connection


<a id="createUserConnection"></a>
# **createUserConnection**
> Connection createUserConnection(connectionRequest, expand, source)

Add a connection

Create a new connection for the authenticated user, for &#x60;credentials&#x60; connectors. The request implies a synchronous interaction with the connector website or API to perform the initial credentials check, so client-side timeouts must be configured to allow a reponse time up to a few minutes. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectionsApi()
val connectionRequest : ConnectionRequest =  // ConnectionRequest | 
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val source : kotlin.String = source_example // kotlin.String | 
try {
    val result : Connection = apiInstance.createUserConnection(connectionRequest, expand, source)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectionsApi#createUserConnection")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectionsApi#createUserConnection")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectionRequest** | [**ConnectionRequest**](ConnectionRequest.md)|  |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: connector, sources, accounts, all_accounts]
 **source** | **kotlin.String**|  | [optional]

### Return type

[**Connection**](Connection.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteUserConnection"></a>
# **deleteUserConnection**
> deleteUserConnection(connectionId, expand)

Delete a connection

Delete a user connection. All associated data is permanently made unavailable in the API.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectionsApi()
val connectionId : kotlin.Long = 789 // kotlin.Long | Connection ID.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    apiInstance.deleteUserConnection(connectionId, expand)
} catch (e: ClientException) {
    println("4xx response calling ConnectionsApi#deleteUserConnection")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectionsApi#deleteUserConnection")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectionId** | **kotlin.Long**| Connection ID. |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: connector, sources, accounts, all_accounts]

### Return type

null (empty response body)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getUserConnection"></a>
# **getUserConnection**
> Connection getUserConnection(connectionId, expand)

Connection

Get a single connection of the authenticated user by ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectionsApi()
val connectionId : kotlin.Long = 789 // kotlin.Long | Connection ID.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : Connection = apiInstance.getUserConnection(connectionId, expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectionsApi#getUserConnection")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectionsApi#getUserConnection")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectionId** | **kotlin.Long**| Connection ID. |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: connector, sources, accounts, all_accounts]

### Return type

[**Connection**](Connection.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listUserConnections"></a>
# **listUserConnections**
> ConnectionsList listUserConnections(expand)

List connections

List all connections of the authenticated user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectionsApi()
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
try {
    val result : ConnectionsList = apiInstance.listUserConnections(expand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectionsApi#listUserConnections")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectionsApi#listUserConnections")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: connector, sources, accounts, all_accounts]

### Return type

[**ConnectionsList**](ConnectionsList.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="openWebauth"></a>
# **openWebauth**
> openWebauth(clientId, token, redirectUri, idConnector, idConnection, source, state)

Open the connector webview

A special redirection endpoint for &#x60;webauth&#x60; connections. The URL must be opened in a browser.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectionsApi()
val clientId : kotlin.Long = 789 // kotlin.Long | The client ID of your client application.
val token : kotlin.String = token_example // kotlin.String | A temporary authorization code to secure the call.
val redirectUri : kotlin.String = redirectUri_example // kotlin.String | The final redirect URL to be redirected to after the flow has completed. This URL must not contain query parameters. Be sure to properly encode it.
val idConnector : kotlin.Long = 789 // kotlin.Long | To add a new connection only, the ID of the connector. The connector must have webauth as its auth_mechanism.
val idConnection : kotlin.Long = 789 // kotlin.Long | To recover or resume a connection only, the ID of the connection.
val source : kotlin.String = source_example // kotlin.String | 
val state : kotlin.String = state_example // kotlin.String | An optional opaque string that will be returned 'as is' with the redirect URL.
try {
    apiInstance.openWebauth(clientId, token, redirectUri, idConnector, idConnection, source, state)
} catch (e: ClientException) {
    println("4xx response calling ConnectionsApi#openWebauth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectionsApi#openWebauth")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **kotlin.Long**| The client ID of your client application. |
 **token** | **kotlin.String**| A temporary authorization code to secure the call. |
 **redirectUri** | **kotlin.String**| The final redirect URL to be redirected to after the flow has completed. This URL must not contain query parameters. Be sure to properly encode it. |
 **idConnector** | **kotlin.Long**| To add a new connection only, the ID of the connector. The connector must have webauth as its auth_mechanism. | [optional]
 **idConnection** | **kotlin.Long**| To recover or resume a connection only, the ID of the connection. | [optional]
 **source** | **kotlin.String**|  | [optional]
 **state** | **kotlin.String**| An optional opaque string that will be returned &#39;as is&#39; with the redirect URL. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="updateSyncUserConnection"></a>
# **updateSyncUserConnection**
> Connection updateSyncUserConnection(connectionId, expand, source, background, connectionUpdateRequest)

Update and/or sync a connection

Update the configuration or the credentials of a connection, and/or perform a sync afterward.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.powens.api.model.*

val apiInstance = ConnectionsApi()
val connectionId : kotlin.Long = 789 // kotlin.Long | Connection ID.
val expand : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val source : kotlin.String = source_example // kotlin.String | 
val background : kotlin.Boolean = true // kotlin.Boolean | Flag to make the request asynchronous (i.e. the API will respond immediately and process the action in background). When using this option, you must implement polling on the resource to monitor the state.
val connectionUpdateRequest : ConnectionUpdateRequest =  // ConnectionUpdateRequest | The request can optionally include new credentials or values to update the connection. An empty request performs a sync.
try {
    val result : Connection = apiInstance.updateSyncUserConnection(connectionId, expand, source, background, connectionUpdateRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConnectionsApi#updateSyncUserConnection")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConnectionsApi#updateSyncUserConnection")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectionId** | **kotlin.Long**| Connection ID. |
 **expand** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] [enum: connector, sources, accounts, all_accounts]
 **source** | **kotlin.String**|  | [optional]
 **background** | **kotlin.Boolean**| Flag to make the request asynchronous (i.e. the API will respond immediately and process the action in background). When using this option, you must implement polling on the resource to monitor the state. | [optional]
 **connectionUpdateRequest** | [**ConnectionUpdateRequest**](ConnectionUpdateRequest.md)| The request can optionally include new credentials or values to update the connection. An empty request performs a sync. | [optional]

### Return type

[**Connection**](Connection.md)

### Authorization


Configure bi_auth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

