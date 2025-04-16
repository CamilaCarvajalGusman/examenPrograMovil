package com.example.data.git
import com.example.domain.Libro


interface RemoteDataSource {
   suspend fun fetch(title: String): Libro
}
