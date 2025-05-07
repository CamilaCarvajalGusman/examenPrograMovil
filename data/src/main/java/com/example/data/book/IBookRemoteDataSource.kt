package com.example.data.book

import com.example.domain.Book

interface IBookRemoteDataSource {
    suspend fun fetch(title:String): Book
}