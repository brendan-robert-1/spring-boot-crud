package com.brobert.crud.exception

open class ServerErrorException : WebApplicationException {
    constructor(e: Throwable?, msg: () -> String?) : super(e, msg)
    constructor(e: Throwable?) : super(e)
    constructor(msg: () -> String?) : super(msg)
    constructor() : super()
}
