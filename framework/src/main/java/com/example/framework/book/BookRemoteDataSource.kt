package com.example.framework.book

import com.example.data.book.IBookRemoteDataSource
import com.example.domain.Book
import com.example.framework.mappers.toModel
import com.example.framework.service.RetrofitBuilder

class BookRemoteDataSource (val retrofitService: RetrofitBuilder): IBookRemoteDataSource{
    override suspend fun fetch(title:String): Book {
        return retrofitService.apiService.getBooks(title).toModel()
    }
}