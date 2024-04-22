package com.powens.sdk.client

import com.powens.sdk.model.ServiceError
import io.ktor.client.plugins.*
import io.ktor.http.*

class ServiceException(
    val statusCode: HttpStatusCode,
    val error: ServiceError?,
    cause: ResponseException
) : Exception("API error ${error?.code}: {${error?.description}", cause)