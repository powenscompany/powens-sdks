
# Transaction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** | ID of the transaction. | 
**idAccount** | **kotlin.Long** | ID of the related account. | 
**date** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Debit date. | 
**type** | [**TransactionType**](TransactionType.md) |  | 
**dateScraped** | **kotlin.String** | Date and time when the transaction has been seen. | 
**rdate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Realization date of the transaction. | 
**coming** | **kotlin.Boolean** | If true, this transaction hasn&#39;t been debited yet. | 
**active** | **kotlin.Boolean** | If false, PFM services will ignore this transaction. | 
**applicationDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Date considered by PFM services. This date can be edited. |  [optional]
**datetime** | **kotlin.String** | Date and time of the debit of the transaction, if available, in UTC. |  [optional]
**&#x60;value&#x60;** | **kotlin.Double** | Value of the transaction. |  [optional]
**grossValue** | **kotlin.Double** | Gross value of the transaction. |  [optional]
**originalValue** | **kotlin.Double** | Value in the original currency. |  [optional]
**originalGrossValue** | **kotlin.Double** | Gross value in the original currency. |  [optional]
**originalCurrency** | [**TransactionOriginalCurrency**](TransactionOriginalCurrency.md) |  |  [optional]
**commission** | **kotlin.Double** | Commission taken on the transaction. |  [optional]
**commissionCurrency** | [**TransactionCommissionCurrency**](TransactionCommissionCurrency.md) |  |  [optional]
**wording** | **kotlin.String** | Label of the transaction, can be edited. |  [optional]
**idCategory** | **kotlin.Long** | ID of the related category. |  [optional]
**rdatetime** | **kotlin.String** | Realization date and time of the transaction, if available, in UTC. |  [optional]
**vdate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Value date of the transaction. |  [optional]
**vdatetime** | **kotlin.String** | Value date and time of the transaction, if available, in UTC. |  [optional]
**bdate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Date used by the bank for the transaction. |  [optional]
**bdatetime** | **kotlin.String** | Date and time used by the bank for the transaction, if available, in UTC. |  [optional]
**idCluster** | **kotlin.Long** | If the transaction is part of a cluster. |  [optional]
**country** | **kotlin.String** | Original country. |  [optional]
**card** | **kotlin.String** | Card number associated with the transaction. |  [optional]
**counterparty** | [**TransactionCounterparty**](TransactionCounterparty.md) |  |  [optional]
**comment** | **kotlin.String** | User comment. |  [optional]
**lastUpdate** | **kotlin.String** | Last update of the transaction. |  [optional]
**deleted** | **kotlin.String** | If set, this transaction has been removed from the bank. |  [optional]
**account** | [**TransactionAccount**](TransactionAccount.md) |  |  [optional]



