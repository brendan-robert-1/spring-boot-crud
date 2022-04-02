package com.brobert.crud.service

import com.brobert.crud.model.api.response.HelloResponse
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CrudService {

    private val logger = KotlinLogging.logger {}

    fun getHello(id: String): String {
        logger.info("beginning hello world...")
        return "hello world!"
    }

    fun addHello(id: String, message: String) =
        HelloResponse(
            message = "added hello: $id, $message"
        )

    fun updateHello(id: String, message: String) =
        HelloResponse(
            message = "updated hello: $id, $message"
        )

    fun deleteHello(id: String) =
        HelloResponse(
            message = "deleted hello: $id"
        )
}
