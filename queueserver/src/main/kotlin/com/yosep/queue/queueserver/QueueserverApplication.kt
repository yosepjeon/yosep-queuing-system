package com.yosep.queue.queueserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QueueserverApplication

fun main(args: Array<String>) {
	runApplication<QueueserverApplication>(*args)
}
