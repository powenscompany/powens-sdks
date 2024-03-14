
# ServiceAccessTokenRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clientId** | **kotlin.String** | Client ID of the application. | 
**clientSecret** | **kotlin.String** | The client secret associated with the client ID. | 
**grantType** | [**inline**](#GrantType) | The only accepted value is &#x60;client_credentials&#x60;. | 
**scope** | [**kotlin.collections.Set&lt;ServiceTokenScope&gt;**](ServiceTokenScope.md) | The service permission scopes to authorize for this token. | 


<a id="GrantType"></a>
## Enum: grant_type
Name | Value
---- | -----
grantType | client_credentials



