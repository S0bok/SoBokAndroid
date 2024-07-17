package com.example.sobokandroid

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.Path

interface ApiService {
    @Headers("Authorization: Bearer EX_OPENAI_API_KEY")
    @POST("v1/chat/completions")
    fun getChatResponse(
        @Body request: ChatRequest
    ): Call<ChatResponse>
}