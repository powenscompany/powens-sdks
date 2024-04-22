package com.powens.sdk.model

import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.datetime.number
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A calendar bound used to query chronological-ordered resources.
 * A bound can be expressed as a full calendar date, a year-month couple, or a year.
 * Value is serialized with the corresponding ISO 8601 representation.
 */
@Serializable(with = CalendarBound.Serializer::class)
sealed class CalendarBound {

    data class Date(val date: LocalDate): CalendarBound()

    data class YearMonth(val year: UInt, val month: Month): CalendarBound()

    data class Year(val year: UInt): CalendarBound()

    object Serializer : KSerializer<CalendarBound> {

        override val descriptor = PrimitiveSerialDescriptor("CalendarBound", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: CalendarBound) {
            when (value) {
                is Date -> encoder.encodeSerializableValue(LocalDate.serializer(), value.date)
                is YearMonth -> encoder.encodeString(
                    value.year.toString().padStart(4, '0')
                            + "-" + value.month.number.toString().padStart(2, '0')
                )
                is Year -> encoder.encodeString(value.year.toString().padStart(4, '0'))
            }
        }

        override fun deserialize(decoder: Decoder): CalendarBound {
            throw UnsupportedOperationException()
        }

    }

}