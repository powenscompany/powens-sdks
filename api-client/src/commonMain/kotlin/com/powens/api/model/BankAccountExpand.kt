package com.powens.api.model

import com.powens.api.infrastructure.Expand
import kotlinx.serialization.Serializable

@Serializable
data class BankAccountExpand(

    val connection: ConnectionExpand? = null

) : Expand()