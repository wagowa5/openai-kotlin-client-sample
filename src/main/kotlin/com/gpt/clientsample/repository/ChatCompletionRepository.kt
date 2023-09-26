package com.gpt.clientsample.repository

import com.gpt.clientsample.domain.ChatCompletionRequest
import com.gpt.clientsample.domain.ChatCompletionResponse

interface ChatCompletionRepository {
    suspend fun createChatCompletion(chatCompletionRequest: ChatCompletionRequest): ChatCompletionResponse
}
