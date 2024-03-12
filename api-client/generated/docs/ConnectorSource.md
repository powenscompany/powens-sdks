
# ConnectorSource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** |  | 
**connectorId** | **kotlin.Long** |  | 
**name** | **kotlin.String** | Name of the connector source. | 
**authMechanism** | [**AuthMechanism**](AuthMechanism.md) |  | 
**priority** | **kotlin.Int** | The source priority order for the synchronization. Sources must be added following priority order. | 
**disabled** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | If set, this source is ignored on synchronizing the connection. |  [optional]



