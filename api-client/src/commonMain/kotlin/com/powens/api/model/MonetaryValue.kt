package com.powens.api.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

// Aliasing to annotated expected implementation ensures usages are always accepted for serialization by the plugin
typealias MonetaryValue = @Serializable(with = MonetaryValueSerializer::class) MonetaryValueImpl

// Actual implementation types left to specific targets
expect class MonetaryValueImpl
expect class MonetaryValueSerializer : KSerializer<MonetaryValueImpl>

expect val MonetaryValue.absoluteValue: MonetaryValue