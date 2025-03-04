package io.junnyland.ai.prompt

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.stereotype.Component

interface PromptGateway {
    @Component
    class PromptOpenAiGateway(
        private val client: ChatClient,
        private val advisors: List<PromptAdvisor>
    ) : PromptGateway {

        fun chatPrompt(prompt: String): ChatResponse = client
            .prompt()
            .advisors(PromptAdvisor.toAdvisor(advisors))
            .user(prompt)
            .system("answer korean always")
            .tools("junnyland")
            .call()
            .chatResponse()
            ?: throw IllegalStateException("No response from the AI service")
    }
}