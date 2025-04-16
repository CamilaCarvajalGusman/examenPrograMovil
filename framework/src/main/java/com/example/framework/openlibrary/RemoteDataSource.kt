package com.example.framework.openlibrary

import com.example.data.git.RemoteDataSource
import com.example.domain.Libro
import com.example.framework.mappers.toModel
import com.example.framework.service.RetrofitBuilder

class RemoteDataSource(
    val retrofitService: RetrofitBuilder
) : RemoteDataSource {


    override suspend fun fetch(title: String): Libro {
        return retrofitService.apiService.getInfoAvatar(title).toModel()
    }
}
