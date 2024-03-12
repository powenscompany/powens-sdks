package com.powens.api.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlin.math.absoluteValue

@Serializable(with = TransactionValueFilter.Serializer::class)
data class TransactionValueFilter(
    val value: Double, val abs: Boolean = false
) {

    object Serializer : KSerializer<TransactionValueFilter> {

        override val descriptor = PrimitiveSerialDescriptor("TransactionValueFilter", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: TransactionValueFilter) {
            encoder.encodeString(
                (if (value.abs) "±" else "") + Json.encodeToString(
                    Double.serializer(),
                    if (value.abs) value.value.absoluteValue else value.value
                )
            )
        }

        override fun deserialize(decoder: Decoder): TransactionValueFilter {
            throw UnsupportedOperationException()
        }

    }
}