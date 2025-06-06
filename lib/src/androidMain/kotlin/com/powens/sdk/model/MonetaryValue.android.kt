package com.powens.sdk.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.math.BigDecimal

actual typealias MonetaryValueImpl = @Serializable(with = MonetaryValueSerializer::class) BigDecimal

internal actual object MonetaryValueSerializer : KSerializer<BigDecimal> {

    actual override val descriptor = PrimitiveSerialDescriptor("BigDecimal", PrimitiveKind.STRING)

    actual override fun serialize(encoder: Encoder, value: BigDecimal) {
        encoder.encodeString(value.toString())
    }

    actual override fun deserialize(decoder: Decoder): BigDecimal {
        return decoder.decodeString().toBigDecimal()
    }

}

internal actual val MonetaryValue.absoluteValue: BigDecimal
    get() = this.abs()