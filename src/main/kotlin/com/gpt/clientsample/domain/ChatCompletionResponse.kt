package com.gpt.clientsample.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class ChatCompletionResponse(
    val id: String,
    @JsonProperty("object") val objectName: String,
    val created: Int,
    val model: String,
    val choices: List<Choice>,
) {
}
