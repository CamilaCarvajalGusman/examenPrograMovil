package com.example.usecases
import com.example.data.OpenLibrary
import com.example.domain.Libro
import kotlinx.coroutines.delay

class FindLibro (val openLibrary: OpenLibrary){
    suspend fun invoke(title: String) : Libro {
        delay(100)
        return Libro("The Lord of the Rings", "J.R.R. Tolkien",1954)
    }
}

