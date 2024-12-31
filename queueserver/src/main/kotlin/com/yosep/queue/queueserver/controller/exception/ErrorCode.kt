package com.yosep.queue.queueserver.controller.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(val httpStatus: HttpStatus, val code: String, val reason: String) {

    QUEUE_ALEADY_REGISTERD_USER(HttpStatus.CONFLICT, "UQ-0001", "Already registered in queue"),
    QUEUE_ALEADY_REGISTERD_USER2(HttpStatus.CONFLICT, "UQ-0001", "Already registered in %s");

    fun build(): ApplicationException = ApplicationException(httpStatus, code, reason)

    fun build(vararg args: Any): ApplicationException = ApplicationException(httpStatus, code, reason.format(args))
}