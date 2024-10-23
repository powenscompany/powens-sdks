package com.powens.sdk.model

import com.powens.sdk.infrastructure.StringSerializer

actual typealias MonetaryValueImpl = String

internal actual typealias MonetaryValueSerializer = StringSerializer

internal actual val MonetaryValue.absoluteValue
    get() = this.trimStart('-')