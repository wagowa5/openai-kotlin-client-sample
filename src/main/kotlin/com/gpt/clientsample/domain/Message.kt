package com.gpt.clientsample.domain

data class Message(
    val role: String,
    val content: String,
    val name: String? = null,
    val functionCall: FunctionCall? = null
) {

}
