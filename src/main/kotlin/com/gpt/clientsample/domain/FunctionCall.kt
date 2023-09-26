package com.gpt.clientsample.domain

data class FunctionCall(
    val name: String,
    val arguments: String,
)
