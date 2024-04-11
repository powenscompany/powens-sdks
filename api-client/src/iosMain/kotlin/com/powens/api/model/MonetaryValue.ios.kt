package com.powens.api.model

import com.powens.api.infrastructure.StringSerializer

actual typealias MonetaryValueImpl = String

actual typealias MonetaryValueSerializer = StringSerializer

actual val MonetaryValue.absoluteValue
    get() = this.trimStart('-')