package com.powens.api.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

actual typealias MonetaryValueImpl = String

actual object MonetaryValueSerializer : KSerializer<String> {

    override val descriptor = PrimitiveSerialDescriptor("String", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: String) {
        encoder.encodeString(value)
    }

    override fun deserialize(decoder: Decoder): String {
        return decoder.decodeString()
    }

}

actual val MonetaryValue.absoluteValue
    get() = this.trimStart('-')