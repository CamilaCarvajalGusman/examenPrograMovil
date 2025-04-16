package com.example.data.git

import com.example.domain.Libro

interface ILocalDataSource {

    fun findByTitle(title: String): Libro
}
