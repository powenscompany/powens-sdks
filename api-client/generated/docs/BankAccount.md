
# BankAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** |  | 
**connectionId** | **kotlin.Long** |  | 
**userId** | **kotlin.Long** |  | 
**idSource** | **kotlin.Long** |  | 
**display** | **kotlin.Boolean** | Whether the bank account should be displayed and included in aggregated metrics. | 
**name** | **kotlin.String** | Display name of the account. | 
**bookmarked** | **kotlin.Boolean** | Whether the bank account is bookmarked. | 
**usage** | [**BankAccountUsage**](BankAccountUsage.md) |  | 
**originalName** | **kotlin.String** | Original name of the account, as exposed on the connector API or website. | 
**type** | [**BankAccountTypeName**](BankAccountTypeName.md) |  | 
**idType** | **kotlin.Long** |  | 
**parentId** | **kotlin.Long** |  |  [optional]
**balance** | [**MonetaryValue**](MonetaryValue.md) | The balance of the bank account. |  [optional]
**coming** | [**MonetaryValue**](MonetaryValue.md) | Amount of coming operations not yet debited. |  [optional]
**currency** | [**Currency**](Currency.md) |  |  [optional]
**lastUpdate** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | Last successful update of the account. |  [optional]
**deleted** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | If set, this account is not found on the website anymore. |  [optional]
**disabled** | [**kotlinx.datetime.LocalDateTime**](kotlinx.datetime.LocalDateTime.md) | If set, this account has been disabled by user and will not be synchronized. |  [optional]
**number** | **kotlin.String** | The bank account number, if available. |  [optional]
**iban** | **kotlin.String** | The bank account IBAN, if available. |  [optional]
**loan** | [**Loan**](Loan.md) |  |  [optional]
**connection** | [**Connection**](Connection.md) |  |  [optional]



