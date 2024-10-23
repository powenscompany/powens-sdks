package com.powens.sdk.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

// Aliasing to annotated expected implementation ensures usages are always accepted for serialization by the plugin
typealias MonetaryValue = @Serializable(with = MonetaryValueSerializer::class) MonetaryValueImpl

// Actual implementation types left to specific targets
expect class MonetaryValueImpl
internal expect class MonetaryValueSerializer : KSerializer<MonetaryValueImpl> {
    override val descriptor: SerialDescriptor
    override fun serialize(encoder: Encoder, value: MonetaryValueImpl)
    override fun deserialize(decoder: Decoder): MonetaryValueImpl
}

internal expect val MonetaryValue.absoluteValue: MonetaryValue