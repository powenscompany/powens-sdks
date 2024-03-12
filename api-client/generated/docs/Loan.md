
# Loan

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**totalAmount** | [**MonetaryValue**](MonetaryValue.md) | Total amount of the loan. |  [optional]
**availableAmount** | [**MonetaryValue**](MonetaryValue.md) | Amount of the loan not yet released and still available. |  [optional]
**usedAmount** | [**MonetaryValue**](MonetaryValue.md) | Amount of the load already used. |  [optional]
**subscriptionDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Subscription date of the loan. |  [optional]
**maturityDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Estimated end date of the loan. |  [optional]
**nextPaymentAmount** | [**MonetaryValue**](MonetaryValue.md) | Amount of the next payment. |  [optional]
**nextPaymentDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Date of the next payment. |  [optional]
**rate** | **kotlin.Double** | Rate of the loan. |  [optional]
**nbPaymentsLeft** | **kotlin.Int** | Number of payments still due. |  [optional]
**nbPaymentsDone** | **kotlin.Int** | Number of payments done. |  [optional]
**nbPaymentsTotal** | **kotlin.Int** | Total number of payments. |  [optional]
**lastPaymentAmount** | [**MonetaryValue**](MonetaryValue.md) | Amount of the last payment. |  [optional]
**lastPaymentDate** | [**kotlinx.datetime.LocalDate**](kotlinx.datetime.LocalDate.md) | Date of the last payment. |  [optional]
**accountLabel** | **kotlin.String** | Name of the debited account. |  [optional]
**insuranceLabel** | **kotlin.String** | Label of the insurance. |  [optional]
**duration** | **kotlin.Int** | Duration of the loan, in months. |  [optional]
**type** | [**inline**](#Type) | Type of the loan: * &#x60;mortgage&#x60;: Mortgage * &#x60;consumercredit&#x60;: Consumer credit * &#x60;revolvingcredit&#x60;: Revolving credit  |  [optional]


<a id="Type"></a>
## Enum: type
Name | Value
---- | -----
type | mortgage, consumercredit, revolvingcredit



