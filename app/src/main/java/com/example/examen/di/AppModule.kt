package com.example.examen.di

import com.example.data.OpenLibraryRepository
import com.example.data.book.IBookRemoteDataSource
import com.example.framework.book.BookRemoteDataSource
import com.example.framework.service.RetrofitBuilder
import com.example.usecases.GetBooks
import dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providerRetrofitBuilder() : RetrofitBuilder {
        return RetrofitBuilder
    }




    @Provides
    @Singleton
    fun bookRemoteDataSource(retrofitService: RetrofitBuilder): IBookRemoteDataSource {
        return BookRemoteDataSource(retrofitService)
    }


    @Provides
    @Singleton
    fun openLibraryRepository(remoteDataSource: IBookRemoteDataSource): OpenLibraryRepository {
        return OpenLibraryRepository(remoteDataSource)
    }


    @Provides
    @Singleton
    fun provideBookUseCases(openLibraryRepository: OpenLibraryRepository): GetBooks {
        return GetBooks(openLibraryRepository)
    }

}
