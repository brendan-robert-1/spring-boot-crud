package com.brobert.crud.advice

import com.brobert.crud.exception.BadRequestException
import com.brobert.crud.exception.ForbiddenException
import com.brobert.crud.exception.InternalServerErrorException
import com.brobert.crud.exception.NotFoundException
import com.brobert.crud.exception.PreconditionFailedException
import com.brobert.crud.model.api.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.FORBIDDEN
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.PRECONDITION_FAILED
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class BaseAdvice {

    /**
     * HTTP 400
     */
    @ExceptionHandler(
        MethodArgumentNotValidException::class,
        HttpMessageNotReadableException::class,
        BadRequestException::class
    )
    fun handleBadRequest(e: Throwable?, req: HttpServletRequest) =
        handleException(BAD_REQUEST, req)

    /**
     * HTTP 403
     */
    @ExceptionHandler(ForbiddenException::class)
    fun handleForbidden(e: Throwable?, req: HttpServletRequest) =
        handleException(FORBIDDEN, req)

    /**
     * HTTP 404
     */
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(e: Throwable?, req: HttpServletRequest) =
        handleException(NOT_FOUND, req)

    /**
     * HTTP 412
     */
    @ExceptionHandler(PreconditionFailedException::class)
    fun handlePreconditionFailed(e: Throwable?, req: HttpServletRequest) =
        handleException(PRECONDITION_FAILED, req)

    /**
     * HTTP 500
     */
    @ExceptionHandler(InternalServerErrorException::class)
    fun handleInternalServerError(e: Throwable?, req: HttpServletRequest) =
        handleException(INTERNAL_SERVER_ERROR, req)

    private fun handleException(httpStatus: HttpStatus, req: HttpServletRequest) =
        ResponseEntity
            .status(httpStatus.value())
            .contentType(APPLICATION_JSON)
            .body(
                ErrorResponse(
                    status = httpStatus.value(),
                    error = httpStatus.reasonPhrase,
                    timestamp = Instant.now(),
                    path = "${req.contextPath}${req.servletPath}"
                )
            )
}
