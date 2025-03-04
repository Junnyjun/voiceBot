package io.junnyland.ai.prompt

import org.junit.jupiter.api.Test
import org.springframework.ai.chat.client.ChatClient

class PromptGatewayTest {

 private val gateway  = PromptGateway.PromptOpenAiGateway(
    client = ChatClient.create()
    advisors = listOf(
     PromptAdvisor.PromptRepositoryAdvisor(),
     PromptAdvisor.PromptTuningAdvisor()
    )
 )

 @Test
 fun

}