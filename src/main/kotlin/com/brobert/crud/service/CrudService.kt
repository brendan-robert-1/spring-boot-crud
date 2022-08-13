package com.brobert.crud.service

import com.brobert.crud.exception.InternalServerErrorException
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CrudService(
    // private val helloRepository: HelloRepository
) {

    private val logger = KotlinLogging.logger {}

    fun getHello(id: String) =
        "hello: $id"
//        try{
//            helloRepository.findByHelloId(id)
//        }catch(e: Exception){
//            "Could not find id: $id".let {
//                logger.error(e){it}
//                throw NotFoundException(e){it}
//            }
//        }

    fun addHello(id: String, message: String) =
        try {
            saveHello(id, message)
            "hello added"
        } catch (e: Exception) {
            "Could not add hello: $id, message: $message".let {
                logger.error(e) { it }
                throw InternalServerErrorException(e) { it }
            }
        }

    fun updateHello(id: String, message: String) =
        try {
            saveHello(id, message)
        } catch (e: Exception) {
            "Could not update hello: $id, message: $message".let {
                logger.error(e) { it }
                throw InternalServerErrorException(e) { it }
            }
        }

    internal fun saveHello(id: String, message: String) =
        ""
//        helloRepository.save(
//            HelloEntity(
//                helloId = id,
//                message = message
//            )
//        )

    fun deleteHello(id: String) =
        ""
//        try{
//            helloRepository.delete(
//                HelloEntity(
//                    helloId = id
//                )
//            )
//        }catch(e: Exception){
//            "Could not delete hello: $id".let {
//                logger.error(e){it}
//                throw InternalServerErrorException(e){it}
//            }
//        }
}
