
# Transaction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** |  | 
**accountId** | **kotlin.Long** |  | 
**date** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Debit date. | 
**type** | [**TransactionType**](TransactionType.md) |  | 
**dateScraped** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Date and time when the transaction has been seen. | 
**realizationDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Realization date of the transaction. | 
**coming** | **kotlin.Boolean** | If true, this transaction hasn&#39;t been debited yet. | 
**active** | **kotlin.Boolean** | If false, PFM services will ignore this transaction. | 
**applicationDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Date considered by PFM services. This date can be edited. |  [optional]
**datetime** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Date and time of the debit of the transaction, if available, in UTC. |  [optional]
**&#x60;value&#x60;** | [**MonetaryValue**](MonetaryValue.md) | Value of the transaction. |  [optional]
**grossValue** | [**MonetaryValue**](MonetaryValue.md) | Gross value of the transaction. |  [optional]
**originalValue** | [**MonetaryValue**](MonetaryValue.md) | Value in the original currency. |  [optional]
**originalGrossValue** | [**MonetaryValue**](MonetaryValue.md) | Gross value in the original currency. |  [optional]
**originalCurrency** | [**Currency**](Currency.md) |  |  [optional]
**commission** | [**MonetaryValue**](MonetaryValue.md) | Commission taken on the transaction. |  [optional]
**commissionCurrency** | [**Currency**](Currency.md) |  |  [optional]
**wording** | **kotlin.String** | Label of the transaction, can be edited. |  [optional]
**categoryId** | **kotlin.Long** | ID of the related category. |  [optional]
**realizationDateTime** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Realization date and time of the transaction, if available, in UTC. |  [optional]
**valueDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Value date of the transaction. |  [optional]
**valueDateTime** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Value date and time of the transaction, if available, in UTC. |  [optional]
**bankDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Date used by the bank for the transaction. |  [optional]
**bankDateTime** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Date and time used by the bank for the transaction, if available, in UTC. |  [optional]
**clusterId** | **kotlin.Long** | If the transaction is part of a cluster. |  [optional]
**country** | **kotlin.String** | Original country. |  [optional]
**card** | **kotlin.String** | Card number associated with the transaction. |  [optional]
**counterparty** | [**TransactionCounterparty**](TransactionCounterparty.md) |  |  [optional]
**comment** | **kotlin.String** | User comment. |  [optional]
**lastUpdate** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Last update of the transaction. |  [optional]
**deleted** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | If set, this transaction has been removed from the bank. |  [optional]
**account** | [**BankAccount**](BankAccount.md) |  |  [optional]



