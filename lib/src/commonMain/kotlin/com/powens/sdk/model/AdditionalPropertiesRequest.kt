package com.powens.sdk.model

import kotlinx.serialization.Serializable

/**
 * A base class for requests that accept free key-value params in addition to schema-defined ones.
 */
@Serializable
// Open API generator requires generic signature
open class AdditionalPropertiesRequest<K, V>(
    val properties: MutableMap<String, String> = mutableMapOf()
) : Map<String, String> by properties