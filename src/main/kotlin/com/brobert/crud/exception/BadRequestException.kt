package com.brobert.crud.exception

class BadRequestException : ClientErrorException {
    constructor(e: Throwable?, msg: () -> String?) : super(e, msg)
    constructor(e: Throwable?) : super(e)
    constructor(msg: () -> String?) : super(msg)
    constructor() : super()
}
