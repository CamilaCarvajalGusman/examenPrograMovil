package com.example.usecases

import com.example.domain.Book
import com.example.data.OpenLibraryRepository

class GetBooks (
     val openLibraryRepository: OpenLibraryRepository
) {
    suspend fun invoke(title:String):Book{
        return openLibraryRepository.getBooks(title)
    }
}