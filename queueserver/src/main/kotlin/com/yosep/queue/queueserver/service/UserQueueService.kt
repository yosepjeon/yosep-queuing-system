package com.yosep.queue.queueserver.service

import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class UserQueueService(
    private val reactiveRedisTemplate: ReactiveRedisTemplate<String, String>
) {

    private val userQueueWaitKey = "users:queue:%s:wait"
    private val userQueueProceedKey = "users:queue:%s:proceed"

    suspend fun registerWaitQueue(queue: String, userId: Long): Long {
        val queueName = userQueueWaitKey.format(queue)
        val unixTimestamp = Instant.now().epochSecond
        val userIdString = userId.toString()
        reactiveRedisTemplate.opsForZSet().add(queueName, userIdString,
            unixTimestamp.toDouble()
        ).awaitSingle()

        return reactiveRedisTemplate.opsForZSet().rank(queueName, userIdString)
            .awaitSingle() + 1
    }
}