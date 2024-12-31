package com.yosep.queue.queueserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.Instant

@SpringBootApplication
class QueueserverApplication

fun main(args: Array<String>) {
	runApplication<QueueserverApplication>(*args)
}
