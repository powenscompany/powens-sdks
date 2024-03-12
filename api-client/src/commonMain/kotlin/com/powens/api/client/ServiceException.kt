package com.powens.api.client

import com.powens.api.model.ServiceError
import io.ktor.client.plugins.*
import io.ktor.http.*

class ServiceException(
    val statusCode: HttpStatusCode,
    val error: ServiceError?,
    cause: ResponseException
) : Exception("API error ${error?.code}: {${error?.description}", cause)