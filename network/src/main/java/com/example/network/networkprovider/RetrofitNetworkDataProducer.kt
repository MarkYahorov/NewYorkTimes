package com.example.network.networkprovider

import com.example.core.producer.NetworkDataProducer
import retrofit2.Retrofit

class RetrofitNetworkDataProducer(private val retrofit: Retrofit) : NetworkDataProducer {
    override fun <T : Any> createService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}