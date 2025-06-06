/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.powens.sdk.model


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param firstDate Minimum available date for results.
 * @param lastDate Maximum available date for results.
 * @param resultMinDate Minimum date of results in the current response.
 * @param resultMaxDate Maximum date of results in the current response.
 */
@Serializable

data class DateBoundedList (

    /* Minimum available date for results. */
    @SerialName(value = "first_date") @Required val firstDate: kotlinx.datetime.LocalDate,

    /* Maximum available date for results. */
    @SerialName(value = "last_date") @Required val lastDate: kotlinx.datetime.LocalDate,

    /* Minimum date of results in the current response. */
    @SerialName(value = "result_min_date") @Required val resultMinDate: kotlinx.datetime.LocalDate,

    /* Maximum date of results in the current response. */
    @SerialName(value = "result_max_date") @Required val resultMaxDate: kotlinx.datetime.LocalDate

) {


}

