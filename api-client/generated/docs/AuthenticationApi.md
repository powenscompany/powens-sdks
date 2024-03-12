# AuthenticationApi

All URIs are relative to *https://demo.biapi.pro/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**exchangeAccessToken**](AuthenticationApi.md#exchangeAccessToken) | **POST** /auth/token/access | Exchange a temporary code for a permanent user access token
[**getAuthCode**](AuthenticationApi.md#getAuthCode) | **GET** /auth/token/code | Generate a temporary code
[**getServiceAccessToken**](AuthenticationApi.md#getServiceAccessToken) | **POST** /auth/token | Generate a service token
[**initUserToken**](AuthenticationApi.md#initUserToken) | **POST** /auth/init | Create a new anonymous user
[**renewAccessToken**](AuthenticationApi.md#renewAccessToken) | **POST** /auth/renew | Generate a new permanent access token for an existing user
[**revokeAccessToken**](AuthenticationApi.md#revokeAccessToken) | **DELETE** /auth/token | Revoke an access token


<a id="exchangeAccessToken"></a>
# **exchangeAccessToken**
> ExchangeAccessToken exchangeAccessToken(exchangeAccessTokenRequest)

Exchange a temporary code for a permanent user access token

This endpoint uses the received temporary token to generate a permanent user access token. 

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = AuthenticationApi()
val exchangeAccessTokenRequest : ExchangeAccessTokenRequest =  // ExchangeAccessTokenRequest | 
try {
    val result : ExchangeAccessToken = apiInstance.exchangeAccessToken(exchangeAccessTokenRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AuthenticationApi#exchangeAccessToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthenticationApi#exchangeAccessToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **exchangeAccessTokenRequest** | [**ExchangeAccessTokenRequest**](ExchangeAccessTokenRequest.md)|  | [optional]

### Return type

[**ExchangeAccessToken**](ExchangeAccessToken.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="getAuthCode"></a>
# **getAuthCode**
> AuthCode getAuthCode(type)

Generate a temporary code

This endpoint requires header authentication with a valid user access token. This endpoint generates a new temporary code for the current user. In case the access token is already used by a trusted device, and you want to temporarily let another one (for example a web browser) access user resources, use this endpoint to generate a code that will expire in 30 minutes. If the generated code is intended to be used with our webview, you can use the &#x60;singleAccess&#x60; token type. 

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = AuthenticationApi()
val type : kotlin.String = type_example // kotlin.String | The type of the temporary code. Default is `requestAccess`.
try {
    val result : AuthCode = apiInstance.getAuthCode(type)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AuthenticationApi#getAuthCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthenticationApi#getAuthCode")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **kotlin.String**| The type of the temporary code. Default is &#x60;requestAccess&#x60;. | [optional] [enum: requestAccess, singleAccess]

### Return type

[**AuthCode**](AuthCode.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getServiceAccessToken"></a>
# **getServiceAccessToken**
> ServiceAccessToken getServiceAccessToken(serviceAccessTokenRequest)

Generate a service token

This endpoint generates a special access token with a dedicated service scope. The generated token will expire after 30 minutes. A service token is a token that is not associated with a user but rather used to access a specific feature or service. For example, the Pay product requires the use of a payment token. Requested permissions are defined in the scope of the token. 

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = AuthenticationApi()
val serviceAccessTokenRequest : ServiceAccessTokenRequest =  // ServiceAccessTokenRequest | 
try {
    val result : ServiceAccessToken = apiInstance.getServiceAccessToken(serviceAccessTokenRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AuthenticationApi#getServiceAccessToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthenticationApi#getServiceAccessToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **serviceAccessTokenRequest** | [**ServiceAccessTokenRequest**](ServiceAccessTokenRequest.md)|  | [optional]

### Return type

[**ServiceAccessToken**](ServiceAccessToken.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="initUserToken"></a>
# **initUserToken**
> AccessToken initUserToken(accessTokenRequest)

Create a new anonymous user

This endpoint generates a new token related to a *new anonymous user*. If &#x60;client_id&#x60; and &#x60;client_secret&#x60; are both supplied, or if you call this endpoint with a manage token, the generated token will be *permanent*. Otherwise, it will expire after 30 minutes. 

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = AuthenticationApi()
val accessTokenRequest : AccessTokenRequest =  // AccessTokenRequest | 
try {
    val result : AccessToken = apiInstance.initUserToken(accessTokenRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AuthenticationApi#initUserToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthenticationApi#initUserToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessTokenRequest** | [**AccessTokenRequest**](AccessTokenRequest.md)|  | [optional]

### Return type

[**AccessToken**](AccessToken.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="renewAccessToken"></a>
# **renewAccessToken**
> ExchangeAccessToken renewAccessToken(renewAccessTokenRequest)

Generate a new permanent access token for an existing user

This endpoint generates a new permanent access token for an existing user, and revokes former tokens if explicitly requested. 

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = AuthenticationApi()
val renewAccessTokenRequest : RenewAccessTokenRequest =  // RenewAccessTokenRequest | 
try {
    val result : ExchangeAccessToken = apiInstance.renewAccessToken(renewAccessTokenRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AuthenticationApi#renewAccessToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthenticationApi#renewAccessToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **renewAccessTokenRequest** | [**RenewAccessTokenRequest**](RenewAccessTokenRequest.md)|  | [optional]

### Return type

[**ExchangeAccessToken**](ExchangeAccessToken.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="revokeAccessToken"></a>
# **revokeAccessToken**
> revokeAccessToken()

Revoke an access token

This endpoint invalidates permanent access tokens. Subsequent calls using the provided permanent access token will fail. 

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = AuthenticationApi()
try {
    apiInstance.revokeAccessToken()
} catch (e: ClientException) {
    println("4xx response calling AuthenticationApi#revokeAccessToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthenticationApi#revokeAccessToken")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

