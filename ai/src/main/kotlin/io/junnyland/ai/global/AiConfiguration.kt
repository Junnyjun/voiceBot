package io.junnyland.ai.global

import org.springframework.ai.chat.client.ChatClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AiConfiguration {

    @Bean
    fun ChatClient(builder: ChatClient.Builder): ChatClient = builder.defaultSystem("answer korean always")
        .defaultTools("junnyland")
        .build()
}