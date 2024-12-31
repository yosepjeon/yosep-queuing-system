package com.yosep.queue.queueserver.controller

import com.yosep.queue.queueserver.controller.dto.response.RegisterUserResponse
import com.yosep.queue.queueserver.service.UserQueueService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/queue")
class UserQueueController(private val userQueueService: UserQueueService) {

    @PostMapping("")
    suspend fun registerUser(@RequestParam(name = "queue", defaultValue = "default", required = false) queue: String,
        @RequestParam(name = "user_id") userId: Long): RegisterUserResponse {
        return RegisterUserResponse(userQueueService.registerWaitQueue(queue, userId))
    }

}