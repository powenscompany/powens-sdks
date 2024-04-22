package com.powens.sdk.model

import com.powens.sdk.infrastructure.Expand
import kotlinx.serialization.Serializable

@Serializable
data class BankAccountExpand(

    val connection: ConnectionExpand? = null

) : Expand()