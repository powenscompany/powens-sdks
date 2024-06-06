package com.powens.sdk.model

import com.powens.sdk.infrastructure.StringSerializer

actual typealias MonetaryValueImpl = String

actual typealias MonetaryValueSerializer = StringSerializer

actual val MonetaryValue.absoluteValue
    get() = this.trimStart('-')