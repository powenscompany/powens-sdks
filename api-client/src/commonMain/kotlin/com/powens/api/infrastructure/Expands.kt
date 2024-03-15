package com.powens.api.infrastructure

import kotlinx.serialization.json.*

open class Expand {

    override fun toString(): String {
        return stringifyExpand(Json.encodeToJsonElement(this).jsonObject)
    }

    private companion object {
        fun stringifyExpand(expand: JsonElement) : String = when (expand) {
            is JsonObject -> expand.map { entry -> entry.key + stringifyExpand(expand) }
                .ifEmpty { null }
                ?.joinToString(",", prefix = "[", postfix = "]") ?: ""
            else -> ""
        }

    }

}