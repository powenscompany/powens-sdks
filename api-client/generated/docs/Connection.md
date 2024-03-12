
# Connection

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** |  | 
**connectorId** | **kotlin.Long** |  | 
**created** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Creation date of the connection. | 
**active** | **kotlin.Boolean** | Whether this connection is active and will be automatically synced. | 
**userId** | **kotlin.Long** | ID of the related user. |  [optional]
**providerId** | **kotlin.Long** |  |  [optional]
**bankId** | **kotlin.Long** |  |  [optional]
**state** | [**ConnectionState**](ConnectionState.md) |  |  [optional]
**error** | [**ConnectionState**](ConnectionState.md) |  |  [optional]
**errorMessage** | **kotlin.String** | If the last update failed, an optional message from the connector to guide the user into recovering from the error. |  [optional]
**fields** | [**kotlin.collections.List&lt;CredentialsField&gt;**](CredentialsField.md) | For connections in an error state, an optional list of form fields that must be prompted to the end-user. |  [optional]
**lastUpdate** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Last successful update. |  [optional]
**lastPush** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Last successful push. |  [optional]
**expire** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Highest value among expiration dates of connection sources. |  [optional]
**connectorUuid** | **kotlin.String** | UUID of the connector. Required if &#x60;id_connector&#x60; is not provided. |  [optional]
**nextTry** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Scheduled date of next synchronization. |  [optional]
**connector** | [**Connector**](Connector.md) |  |  [optional]
**sources** | [**kotlin.collections.List&lt;ConnectionSource&gt;**](ConnectionSource.md) | Optional &#x60;expand&#x60;: The details of the sources configured for the connection. |  [optional]
**accounts** | [**kotlin.collections.List&lt;BankAccount&gt;**](BankAccount.md) | Optional &#x60;expand&#x60;: The list of activated bank accounts associated with the connection (disabled accounts are omitted). |  [optional]
**allAccounts** | [**kotlin.collections.List&lt;BankAccount&gt;**](BankAccount.md) | Optional &#x60;expand&#x60;: The list of all bank accounts associated with the connection, including disabled ones. |  [optional]



