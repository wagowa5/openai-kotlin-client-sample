package com.gpt.clientsample.infrastructure

import com.gpt.clientsample.domain.ChatCompletionRequest
import com.gpt.clientsample.domain.ChatCompletionResponse
import com.gpt.clientsample.repository.ChatCompletionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class WebClientChatCompletionRepository(
    @Autowired private val webClientBuilder: WebClient.Builder
) : ChatCompletionRepository {
    override suspend fun createChatCompletion(chatCompletionRequest: ChatCompletionRequest): ChatCompletionResponse {
        val webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build()

        return webClient.post()
            .uri("/chat/completions")
            .header("Authorization", "Bearer <Your-API-Key>")
            .bodyValue(chatCompletionRequest)
            .retrieve()
            .bodyToMono(ChatCompletionResponse::class.java)
            .awaitSingle()
    }
}
