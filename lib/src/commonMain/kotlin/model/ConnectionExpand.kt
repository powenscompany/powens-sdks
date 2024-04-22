package com.powens.sdk.model

import com.powens.sdk.infrastructure.Expand
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConnectionExpand(

    val connector: ConnectorExpand? = null,

    val sources: Boolean = false,

    val accounts: BankAccountExpand? = null,

    @SerialName("all_accounts")
    val allAccounts: BankAccountExpand? = null

) : Expand()