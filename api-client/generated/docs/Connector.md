
# Connector

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** |  | 
**uuid** | **kotlin.String** | Unique connector identifier, stable across API domains. | 
**name** | **kotlin.String** | Name of the bank or provider. | 
**charged** | **kotlin.Boolean** | Whether usage of this connector is charged. | 
**beta** | **kotlin.Boolean** | If true, this connector is likely instable. | 
**capabilities** | [**inline**](#kotlin.collections.List&lt;Capabilities&gt;) | A list of capabilities supported by this connector. | 
**authMechanism** | [**AuthMechanism**](AuthMechanism.md) |  | 
**restricted** | **kotlin.Boolean** | If true, new connections cannot be added with this connector. | 
**hidden** | **kotlin.Boolean** | Whether this connector is hidden from users. |  [optional]
**code** | **kotlin.String** | For bank connectors, the bank code. |  [optional]
**color** | **kotlin.String** | Branding color of the bank or provider. |  [optional]
**slug** | **kotlin.String** | A short letter code to identify the connector. Slugs are not unique. |  [optional]
**urls** | **kotlin.collections.List&lt;kotlin.String&gt;** | A list of websites associated with the connector. |  [optional]
**syncPeriodicity** | **kotlin.Float** | How many days to wait between syncs. |  [optional]
**monthsToFetch** | **kotlin.Int** | Number of months of history to fetch when synchronizing a connection. |  [optional]
**transferMechanism** | [**AuthMechanism**](AuthMechanism.md) |  |  [optional]
**siret** | **kotlin.String** | For provider connectors, the SIRET code. |  [optional]
**sources** | [**kotlin.collections.List&lt;ConnectorSource&gt;**](ConnectorSource.md) | Optional &#x60;expand&#x60;: The details of the sources available for the connector. |  [optional]
**fields** | [**kotlin.collections.List&lt;CredentialsField&gt;**](CredentialsField.md) | Optional &#x60;expand&#x60;: The list of initial form fields associated with the connector. Only relevant when building a custom connection integration. |  [optional]
**countries** | [**kotlin.collections.List&lt;ConnectorCountry&gt;**](ConnectorCountry.md) | Optional &#x60;expand&#x60;: Countries where users can open or have accounts/subscriptions with the given institution. |  [optional]


<a id="kotlin.collections.List<Capabilities>"></a>
## Enum: capabilities
Name | Value
---- | -----
capabilities | bank, bankwealth, transfer, document, profile, contact



