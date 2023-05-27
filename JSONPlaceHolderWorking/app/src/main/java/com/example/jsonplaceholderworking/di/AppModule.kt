package com.example.jsonplaceholderworking.di

import com.example.jsonplaceholderworking.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    @Provides
    @Singleton
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun getOkHttpClient(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        return httpBuilder
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(getOkHttpClient())
        .build()

    @Provides
    @Singleton
    fun getApi(retrofit: Retrofit): ApiInterface = retrofit
        .create(ApiInterface::class.java)

}