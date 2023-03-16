package com.product.recommend.redis

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.redisson.spring.data.connection.RedissonConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
class RedisConfig(
        @Value("\${spring.redis.port}")
        val port: Int,
        @Value("\${spring.redis.host}")
        val host: String
) {
    private lateinit var redissonClient: RedissonClient

    fun getClient(): RedissonClient {
        return if (::redissonClient.isInitialized) redissonClient
        else {
            val config = Config()
            config.useSingleServer()
                    .address = "redis://$host:$port"

            return Redisson.create(config)
        }
    }

    @Bean
    fun redisTemplate(): RedisTemplate<*, *> {
        return RedisTemplate<Any, Any>().apply {
            this.setConnectionFactory(RedissonConnectionFactory())

            // "\xac\xed\x00" 같은 불필요한 해시값을 보지 않기 위해 serializer 설정
            this.keySerializer = StringRedisSerializer()
            this.hashKeySerializer = StringRedisSerializer()
            this.valueSerializer = StringRedisSerializer()
        }
    }

    @Bean
    fun redissonConnectionFactory(): RedissonConnectionFactory? {
        return RedissonConnectionFactory(getClient())
    }
}