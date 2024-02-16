
# AuthCode

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **kotlin.String** | The generated temporary code. | 
**type** | [**inline**](#Type) | The type of the generated code. The only value is &#x60;temporary&#x60;. | 
**access** | [**inline**](#Access) | The type of access granted, &#x60;single&#x60; or &#x60;standard&#x60;. | 
**expiresIn** | **kotlin.Int** | The expiration delay of the code, in seconds. |  [optional]


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | temporary


<a id="Access"></a>
## Enum: access
Name | Value
---- | -----
access | single, standard



