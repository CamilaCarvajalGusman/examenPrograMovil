package com.example.data

import com.example.domain.Libro
import com.sun.tools.javac.util.Context


class BookRepository( val context: Context) {
    val libroDao = AppRoomDatabase.getDatabase(context).bookDao()


    suspend fun insert(libro: Libro) {
       libroDao.insert(libro)
    }

    fun getListBooks(): List<Libro> {
        return libroDao.getList()
    }
}