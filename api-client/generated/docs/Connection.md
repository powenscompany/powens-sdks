
# Connection

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** | ID of the connection. | 
**idConnector** | **kotlin.Long** | ID of the related connector. | 
**created** | **kotlin.String** | Creation date of the connection. | 
**active** | **kotlin.Boolean** | Whether this connection is active and will be automatically synced. | 
**idUser** | **kotlin.Long** | ID of the related user. |  [optional]
**idProvider** | **kotlin.Long** | ID of the provider. |  [optional]
**idBank** | **kotlin.Long** | ID of the bank. |  [optional]
**state** | [**ConnectionState**](ConnectionState.md) |  |  [optional]
**error** | [**ConnectionState**](ConnectionState.md) |  |  [optional]
**errorMessage** | **kotlin.String** | If the last update failed, an optional message from the connector to guide the user into recovering from the error. |  [optional]
**fields** | [**kotlin.collections.List&lt;CredentialsField&gt;**](CredentialsField.md) | For connections in an error state, an optional list of form fields that must be prompted to the end-user. |  [optional]
**lastUpdate** | **kotlin.String** | Last successful update. |  [optional]
**lastPush** | **kotlin.String** | Last successful push. |  [optional]
**expire** | **kotlin.String** | Highest value among expiration dates of connection sources. |  [optional]
**connectorUuid** | **kotlin.String** | UUID of the connector. Required if &#x60;id_connector&#x60; is not provided. |  [optional]
**nextTry** | **kotlin.String** | Scheduled date of next synchronization. |  [optional]
**connector** | [**ConnectionConnector**](ConnectionConnector.md) |  |  [optional]
**sources** | [**kotlin.collections.List&lt;ConnectionSource&gt;**](ConnectionSource.md) | Optional &#x60;expand&#x60;: The details of the sources configured for the connection. |  [optional]
**accounts** | [**kotlin.collections.List&lt;BankAccount&gt;**](BankAccount.md) | Optional &#x60;expand&#x60;: The list of activated bank accounts associated with the connection (disabled accounts are omitted). |  [optional]
**allAccounts** | [**kotlin.collections.List&lt;BankAccount&gt;**](BankAccount.md) | Optional &#x60;expand&#x60;: The list of all bank accounts associated with the connection, including disabled ones. |  [optional]



