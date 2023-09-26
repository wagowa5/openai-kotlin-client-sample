package com.gpt.clientsample.application.service

import com.gpt.clientsample.domain.ChatCompletionRequest
import com.gpt.clientsample.domain.ChatCompletionResponse
import com.gpt.clientsample.repository.ChatCompletionRepository
import org.springframework.stereotype.Service

@Service
class ChatCompletionService(
    private val chatCompletionRepository: ChatCompletionRepository
) {
    suspend fun createChatCompletion(chatCompletionRequest: ChatCompletionRequest): ChatCompletionResponse {
        return chatCompletionRepository.createChatCompletion(chatCompletionRequest)
    }
}
