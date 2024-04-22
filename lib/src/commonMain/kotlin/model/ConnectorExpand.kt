package com.powens.sdk.model

import com.powens.sdk.infrastructure.Expand
import kotlinx.serialization.Serializable

@Serializable
data class ConnectorExpand(

    val fields: Boolean = false,

    val sources: Boolean = false,

    val countries: Boolean = false

) : Expand()