package com.gpt.clientsample.domain

data class Choice(
    val index: Int,
    val message: Message,
    val finishReason: String,
    val usage: Usage
)
