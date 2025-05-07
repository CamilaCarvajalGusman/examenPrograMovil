package com.example.usecases

import com.example.data.OpenLibraryRepository
import com.example.domain.Book

class GetSavedBooks(private val repository: OpenLibraryRepository) {
   // suspend operator fun invoke(): List<Book> = repository.getSavedBooks()
}
