package com.example.data

import com.example.data.book.IBookRemoteDataSource
import com.example.domain.Book


class OpenLibraryRepository  (val remoteDataSource: IBookRemoteDataSource){
    suspend fun getBooks(title: String): Book {
        return this.remoteDataSource.fetch(title)
    }
    fun getSavedBooks(){

    }
    fun saveBook(book:Book){

    }
}