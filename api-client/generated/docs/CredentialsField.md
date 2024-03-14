
# CredentialsField

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **kotlin.String** | Technical name of the field. | 
**type** | [**inline**](#Type) | The type of the field, to determine the appropriate UI component. | 
**authMechanisms** | [**kotlin.collections.Set&lt;AuthMechanism&gt;**](AuthMechanism.md) | The list of the authentication mechanisms associated with this field. | 
**label** | **kotlin.String** | A short display label for the field. | 
**required** | **kotlin.Boolean** | Whether posting the field value is required when creating or updating the connection. | 
**description** | **kotlin.String** | A longer help text for the field. |  [optional]
**regex** | **kotlin.String** | An optional regular expression that the value must match. |  [optional]
**propertyValues** | [**kotlin.collections.List&lt;CredentialsFieldValue&gt;**](CredentialsFieldValue.md) | For &#x60;list&#x60; fields, the possible values. |  [optional]


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | text, list, date, number, password



