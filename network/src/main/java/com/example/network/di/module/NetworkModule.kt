package com.example.network.di.module

import com.example.core.producer.NetworkDataProducer
import com.example.network.ApiKeyInterceptor
import com.example.network.BASE_URL
import com.example.network.networkprovider.RetrofitNetworkDataProducer
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @Provides
    fun provideApiKeyInterceptor(): Interceptor {
        return ApiKeyInterceptor()
    }

    @Provides
    fun provideOkHttpClient(apiKeyInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideNetworkProducer(retrofit: Retrofit): NetworkDataProducer {
        return RetrofitNetworkDataProducer(retrofit)
    }
}