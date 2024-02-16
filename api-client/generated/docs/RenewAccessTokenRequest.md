
# RenewAccessTokenRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**grantType** | [**inline**](#GrantType) | The only accepted value is &#x60;client_credentials&#x60;. | 
**clientId** | **kotlin.String** | Client ID of the application. | 
**clientSecret** | **kotlin.String** | The client secret associated with the client ID. | 
**idUser** | **kotlin.Long** | User for whom the token has to be generated. If not supplied, a user will be created. |  [optional]
**revokePrevious** | **kotlin.Boolean** | If true, all other permanent tokens for the user will be deleted. The default is false. |  [optional]


<a id="GrantType"></a>
## Enum: grant_type
Name | Value
---- | -----
grantType | client_credentials



