
# ExchangeAccessTokenRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clientId** | **kotlin.String** | Client ID of the application. | 
**clientSecret** | **kotlin.String** | The client secret associated with the client ID. | 
**code** | **kotlin.String** | The temporary code that was delivered. | 
**grantType** | [**inline**](#GrantType) | The only accepted (and default) value is &#x60;authorization_code&#x60;. |  [optional]
**redirectUri** | **kotlin.String** | The exact &#x60;redirect_uri&#x60; that was specified during the initial OAuth2 step. |  [optional]


<a id="GrantType"></a>
## Enum: grant_type
Name | Value
---- | -----
grantType | authorization_code



