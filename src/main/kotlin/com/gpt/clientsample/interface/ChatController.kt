package com.gpt.clientsample.`interface`

import com.gpt.clientsample.domain.ChatCompletionRequest
import com.gpt.clientsample.domain.ChatCompletionResponse
import com.gpt.clientsample.domain.Message
import org.hibernate.internal.util.collections.CollectionHelper.listOf
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/chat")
class ChatController(
    private val webClient: WebClient.Builder
) {

    @PostMapping("/complete")
    fun completeChat(@RequestBody message: String): Mono<ChatCompletionResponse> {
        // ダミーデータを含むリクエストボディの作成
        val requestBody = ChatCompletionRequest(
            model = "gpt-3.5-turbo",
            messages = listOf(
                Message(role = "system", content = "You are a helpful assistant."),
                Message(role = "user", content = message),
            )
        )

        // OpenAI APIへのPOSTリクエスト
        return webClient.build().post()
            .uri("https://api.openai.com/v1/chat/completions")
            .header("Authorization", "Bearer YOUR_API_KEY") // APIキーを設定
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(ChatCompletionResponse::class.java) // レスポンスボディの型を指定
    }
}
