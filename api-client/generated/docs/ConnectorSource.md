
# ConnectorSource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** | ID of the connector source. | 
**idConnector** | **kotlin.Long** | ID of the related connector. | 
**name** | **kotlin.String** | Name of the connector source. | 
**authMechanism** | [**AuthMechanism**](AuthMechanism.md) |  | 
**priority** | **kotlin.Int** | The source priority order for the synchronization. Sources must be added following priority order. | 
**disabled** | **kotlin.String** | If set, this source is ignored on synchronizing the connection. |  [optional]



