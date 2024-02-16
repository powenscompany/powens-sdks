package com.powens.api.model

import kotlinx.serialization.Serializable

@Serializable
open class AdditionalProperties<K, V>(
    val properties: MutableMap<String, V> = mutableMapOf()
) : Map<String, V> by properties