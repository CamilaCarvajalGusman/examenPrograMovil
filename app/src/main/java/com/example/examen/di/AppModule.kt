package com.example.examen.di

import com.example.data.OpenLibrary
import com.example.data.git.ILocalDataSource
import com.example.data.git.RemoteDataSource
import com.example.usecases.FindLibro
import com.example.framework.service.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerRetrofitBuilder(): RetrofitBuilder {
        return RetrofitBuilder
    }

    @Provides
    @Singleton
    fun gitRemoteDataSource(retrofitService: RetrofitBuilder): RemoteDataSource {
        return RemoteDataSource(retrofitService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(): ILocalDataSource {
        return ILocalDataSource()
    }

    @Provides
    @Singleton
    fun gitRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: ILocalDataSource
    ): OpenLibrary {
        return OpenLibrary(remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideGitUseCases(githubRepository: OpenLibrary): FindLibro {
        return FindLibro(githubRepository)
    }
}