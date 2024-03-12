package com.powens.api.model

import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.datetime.number
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json

@Serializable(with = CalendarBound.Serializer::class)
sealed class CalendarBound {

    data class Date(val date: LocalDate): CalendarBound()

    data class YearMonth(val month: Month, val year: UInt): CalendarBound()

    data class Year(val year: UInt): CalendarBound()

    object Serializer : KSerializer<CalendarBound> {

        override val descriptor = PrimitiveSerialDescriptor("CalendarBound", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: CalendarBound) {
            encoder.encodeString(
                when (value) {
                    is Date -> Json.encodeToString(LocalDate.serializer(), value.date)
                    is YearMonth -> value.year.toString() + "-" + value.month.number.toString().padStart(2)
                    is Year -> value.year.toString()
                }
            )
        }

        override fun deserialize(decoder: Decoder): CalendarBound {
            throw UnsupportedOperationException()
        }

    }

}