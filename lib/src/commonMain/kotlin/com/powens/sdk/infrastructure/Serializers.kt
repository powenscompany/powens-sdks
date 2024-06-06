package com.powens.sdk.infrastructure

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class StringSerializer : KSerializer<String> {

    override val descriptor = PrimitiveSerialDescriptor("String", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: String) {
        encoder.encodeString(value)
    }

    override fun deserialize(decoder: Decoder): String {
        return decoder.decodeString()
    }

}

class IdsAsStringSerializer : KSerializer<List<Long>> {

    override val descriptor = PrimitiveSerialDescriptor("IdsAsLong", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: List<Long>) {
        encoder.encodeString(value.joinToString(","))
    }

    override fun deserialize(decoder: Decoder): List<Long> {
        return decoder.decodeString().split(",").map { it.toLong() }
    }

}