package com.powens.api.model

import com.powens.api.infrastructure.Expand
import kotlinx.serialization.Serializable

@Serializable
data class ConnectorExpand(

    val fields: Boolean = false,

    val sources: Boolean = false,

    val countries: Boolean = false

) : Expand()