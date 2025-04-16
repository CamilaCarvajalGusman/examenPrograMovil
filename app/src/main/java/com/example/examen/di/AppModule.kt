package com.example.examen.di
import com.example.data.OpenLibrary
import com.example.data.git.RemoteDataSource
import com.example.usecases.FindLibro
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.framework.service.RetrofitBuilder
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
    fun gitRemoteDataSource(retrofitService: RetrofitBuilder): RemoteDataSource {
        return RemoteDataSource(retrofitService)
    }

    @Provides
    @Singleton
    fun gitRepository(remoteDataSource: RemoteDataSource): OpenLibrary {
        return OpenLibrary(remoteDataSource)
    }


    @Provides
    @Singleton
    fun provideGitUseCases(githubRepository: OpenLibrary): FindLibro {
        return FindLibro(githubRepository)
    }

}
