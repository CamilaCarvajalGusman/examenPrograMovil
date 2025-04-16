package com.example.framework.service

import com.example.framework.dto.LibroResponseDto
import retrofit2.http.GET
import retrofit2.http.Path


interface IApiService {
    @GET("/users/{githubLogin}")
    suspend fun getInfoAvatar(@Path("githubLogin") githubLogin: String): LibroResponseDto
}
