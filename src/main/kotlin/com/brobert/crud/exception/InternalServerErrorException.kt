package com.brobert.crud.exception

class InternalServerErrorException : ServerErrorException {
    constructor(e: Throwable?, msg: () -> String?) : super(e, msg)
    constructor(e: Throwable?) : super(e)
    constructor(msg: () -> String?) : super(msg)
    constructor() : super()
}
