
# ConnectionSource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** | ID of the connection connection. | 
**idConnection** | **kotlin.Long** | ID of the related connection. | 
**idConnectorSource** | **kotlin.Long** | ID of the related connector source. | 
**name** | **kotlin.String** | Technical code name of the connection source. | 
**created** | **kotlin.String** | Creation date of the source. | 
**state** | [**ConnectionState**](ConnectionState.md) |  |  [optional]
**lastUpdate** | **kotlin.String** | Last successful update of the source. |  [optional]
**disabled** | **kotlin.String** | If set, this source is ignored on synchronizing the connection. |  [optional]
**nextTry** | **kotlin.String** | Scheduled date of next synchronization. |  [optional]
**accessExpire** | **kotlin.String** | Expiration date of the access, if known. |  [optional]



