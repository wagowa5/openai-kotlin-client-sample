package com.gpt.clientsample.domain

data class ChatCompletionRequest(
    val model: String,
    val messages: List<Message>,
    val functions: List<FunctionCall>? = null,
    val function_call: String? = null,
    val temperature: Double? = null,
    val top_p: Double? = null,
    val n: Int? = null,
    val stream: Boolean? = null,
    val stop: List<String>? = null,
    val max_tokens: Int? = null,
    val presence_penalty: Double? = null,
    val frequency_penalty: Double? = null,
    val logit_bias: Map<String, Double>? = null,
    val user: String? = null
) {

}
