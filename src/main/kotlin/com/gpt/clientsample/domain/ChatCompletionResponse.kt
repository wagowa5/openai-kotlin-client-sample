package com.gpt.clientsample.domain

data class ChatCompletionResponse(
    val id: String,
    val obj: String,
    val created: Int,
    val model: String,
    val choices: List<Choice>,
)
