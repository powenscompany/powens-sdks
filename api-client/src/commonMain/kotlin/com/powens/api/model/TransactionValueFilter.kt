package com.powens.api.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json

/**
 * A structure to represent a constraint on the value of a transaction, used for filtering.
 * The structure holds a base value and an "absolute" flag that adds a "±" prefix on serializing.
 */
@Serializable(with = TransactionValueFilter.Serializer::class)
data class TransactionValueFilter(
    val value: MonetaryValue, val absolute: Boolean = false
) {

    object Serializer : KSerializer<TransactionValueFilter> {

        override val descriptor = PrimitiveSerialDescriptor("TransactionValueFilter", PrimitiveKind.STRING)
        private val monetaryValueSerializer = kotlinx.serialization.serializer<MonetaryValue>()

        override fun serialize(encoder: Encoder, value: TransactionValueFilter) {
            encoder.encodeString(
                (if (value.absolute) "±" else "") + Json.encodeToString(
                    monetaryValueSerializer,
                    if (value.absolute) value.value.absoluteValue else value.value
                )
            )
        }

        override fun deserialize(decoder: Decoder): TransactionValueFilter {
            throw UnsupportedOperationException()
        }

    }

}