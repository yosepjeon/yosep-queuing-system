package com.yosep.queue.queueserver.controller.exception

import org.springframework.http.HttpStatus

class ApplicationException(
    httpStatus: HttpStatus,
    code: String,
    reason: String
): RuntimeException() {
}