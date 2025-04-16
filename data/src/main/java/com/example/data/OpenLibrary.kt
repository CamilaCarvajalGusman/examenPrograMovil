package com.example.data
import com.example.data.git.ILocalDataSource
import com.example.data.git.RemoteDataSource
import com.example.domain.Libro

class OpenLibrary (val remoteDataSource: RemoteDataSource,  private val localDataSource: ILocalDataSource){

        suspend fun findbyTitle(title: String): Libro {
            return this.remoteDataSource.fetch(title)
        }
}