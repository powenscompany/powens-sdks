
# BankAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.Long** | ID of the bank account. | 
**idConnection** | **kotlin.Long** | ID of the related connection. | 
**idUser** | **kotlin.Long** | ID of the related user. | 
**idSource** | **kotlin.Long** | ID of the related connection source. | 
**originalName** | **kotlin.String** | Original name of the account, as exposed on the connector API or website. | 
**type** | [**BankAccountTypeName**](BankAccountTypeName.md) |  | 
**idType** | **kotlin.Long** | Bank account type | 
**display** | **kotlin.Boolean** | Whether the bank account should be displayed and included in aggregated metrics. | 
**name** | **kotlin.String** | Display name of the account. | 
**bookmarked** | **kotlin.Boolean** | Whether the bank account is bookmarked. | 
**usage** | [**BankAccountUsage**](BankAccountUsage.md) |  | 
**idParent** | **kotlin.Long** | ID of the parent account, if any. |  [optional]
**balance** | **kotlin.Double** | The balance of the bank account. |  [optional]
**coming** | **kotlin.Double** | Amount of coming operations not yet debited. |  [optional]
**currency** | [**Currency**](Currency.md) | Currency of the bank account. |  [optional]
**lastUpdate** | **kotlin.String** | Last successful update of the account. |  [optional]
**deleted** | **kotlin.String** | If set, this account is not found on the website anymore. |  [optional]
**disabled** | **kotlin.String** | If set, this account has been disabled by user and will not be synchronized. |  [optional]
**number** | **kotlin.String** | The bank account number, if available. |  [optional]
**iban** | **kotlin.String** | The bank account IBAN, if available. |  [optional]
**loan** | **kotlin.String** | For &#x60;loan&#x60; accounts, the loan details. |  [optional]
**connection** | [**Connection**](Connection.md) | Optional &#x60;expand&#x60;: The connection associated with this bank account. |  [optional]



