# UsersApi

All URIs are relative to *https://demo.biapi.pro/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteUser**](UsersApi.md#deleteUser) | **DELETE** /users/me | Delete the authenticated user
[**getUser**](UsersApi.md#getUser) | **GET** /users/me | Authenticated user


<a id="deleteUser"></a>
# **deleteUser**
> deleteUser()

Delete the authenticated user

Delete the user associated with the authorization token. All associated data is removed from the API.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = UsersApi()
try {
    apiInstance.deleteUser()
} catch (e: ClientException) {
    println("4xx response calling UsersApi#deleteUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsersApi#deleteUser")
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

<a id="getUser"></a>
# **getUser**
> User getUser()

Authenticated user

Get information for the user associated with the authentication token.

### Example
```kotlin
// Import classes:
//import com.powens.api.infrastructure.*
//import com.powens.api.model.*

val apiInstance = UsersApi()
try {
    val result : User = apiInstance.getUser()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsersApi#getUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsersApi#getUser")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

