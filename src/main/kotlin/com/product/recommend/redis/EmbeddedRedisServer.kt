package com.product.recommend.redis

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import redis.embedded.RedisServer
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@Configuration
class EmbeddedRedisServer(@Value("\${spring.redis.port}")
                          private var port: Int) {
    private val log = LoggerFactory.getLogger(javaClass)
    private var redisServer: RedisServer = createServer()

    @PostConstruct
    fun startServer() {
        log.info(">>>>>>>>>>>>>>>> embedded redis server is start. port is {}", port)
        createServer().start()
    }

    @PreDestroy
    fun stopServer() {
        log.info(">>>>>>>>>>>>>>>> embedded redis server is stop. port is {}", port)
        redisServer.stop()
    }

    private fun createServer(): RedisServer {
        return RedisServer.builder()
                .setting("maxmemory 128M")
                .port(port)
                .build()
    }
}