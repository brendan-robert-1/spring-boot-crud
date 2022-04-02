package com.brobert.crud.controller

import com.brobert.crud.service.CrudService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(
    private val crudService: CrudService
) {
    companion object {
        const val DOMAIN_PATH = "/v1"
    }
    @GetMapping(
        path = ["$DOMAIN_PATH/id/{id}"],
        produces = [APPLICATION_JSON_VALUE]
    )
    fun getHello(
        @PathVariable("id") id: String,
    ) =
        crudService.getHello(id)

    @PostMapping(
        path = ["$DOMAIN_PATH/id/{id}/message/{message}/add"],
        produces = [APPLICATION_JSON_VALUE]
    )
    fun addHello(
        @PathVariable("id") id: String,
        @PathVariable("message") message: String
    ) = crudService.addHello(id, message)

    @PostMapping(
        path = ["$DOMAIN_PATH/id/{id}/message/{message}/update"],
        produces = [APPLICATION_JSON_VALUE]
    )
    fun updateHello(
        @PathVariable("id") id: String,
        @PathVariable("message") message: String
    ) = crudService.updateHello(id, message)

    @PostMapping(
        path = ["$DOMAIN_PATH/id/{id}/delete"],
        produces = [APPLICATION_JSON_VALUE]
    )
    fun deleteHello(
        @PathVariable id: String
    ) = crudService.deleteHello(id)
}
