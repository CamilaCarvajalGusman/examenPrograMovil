package com.example.framework.service

import com.example.framework.dto.BookResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiService {
    @GET("/users/{githubLogin}")
    suspend fun getBooks(@Path("githubLogin") githubLogin: String): BookResponseDto
}