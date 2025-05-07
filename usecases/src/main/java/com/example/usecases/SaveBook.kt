package com.example.usecases

import com.example.data.OpenLibraryRepository
import com.example.domain.Book

class SaveBook(private val repository: OpenLibraryRepository) {
   // suspend operator fun invoke(book: Book) = repository.saveBook(book)
}
