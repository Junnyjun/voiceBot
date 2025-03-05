package io.junnyland.ai.prompt

import org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor
import org.springframework.ai.chat.client.advisor.VectorStoreChatMemoryAdvisor
import org.springframework.ai.chat.memory.ChatMemory
import org.springframework.ai.chat.memory.InMemoryChatMemory
import org.springframework.stereotype.Component

interface PromptAdvisor {

    companion object {
        fun toAdvisor(adviors: List<PromptAdvisor>): List<AbstractChatMemoryAdvisor<*>> = adviors.map { it.advisor() }
    }

    fun advisor(): AbstractChatMemoryAdvisor<*>

    @Component
    class PromptRepositoryAdvisor(
        private val dataSource: InMemoryChatMemory = InMemoryChatMemory(),
    ) : PromptAdvisor {

        override fun advisor(): AbstractChatMemoryAdvisor<ChatMemory> =
            MessageChatMemoryAdvisor(dataSource)
    }

    @Component
    class PromptTuningAdvisor(
        private val dataSource: InMemoryChatMemory = InMemoryChatMemory(),
    ) : PromptAdvisor {

        override fun advisor(): AbstractChatMemoryAdvisor<ChatMemory> =
            QuestionAnswerAdvisor(VectorStoreChatMemoryAdvisor())
    }
}