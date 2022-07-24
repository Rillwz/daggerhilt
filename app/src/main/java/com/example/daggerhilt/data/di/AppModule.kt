package com.example.daggerhilt.data.di

import android.app.Application
import com.example.daggerhilt.data.remote.MyApi
import com.example.daggerhilt.data.repository.MyRepositoryImpl
import com.example.daggerhilt.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "hello one"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "hello two"

}