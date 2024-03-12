
# ConnectionSource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** |  | 
**connectionId** | **kotlin.Long** |  | 
**connectorSourceId** | **kotlin.Long** |  | 
**name** | **kotlin.String** | Technical code name of the connection source. | 
**created** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Creation date of the source. | 
**state** | [**ConnectionState**](ConnectionState.md) |  |  [optional]
**lastUpdate** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Last successful update of the source. |  [optional]
**disabled** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | If set, this source is ignored on synchronizing the connection. |  [optional]
**nextTry** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Scheduled date of next synchronization. |  [optional]
**accessExpire** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Expiration date of the access, if known. |  [optional]



