package com.brobert.crud.exception

class ForbiddenException : ClientErrorException {
    constructor(e: Throwable?) : super(e)
    constructor(msg: () -> String?) : super(msg)
    constructor() : super()
}
