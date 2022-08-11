package com.example.network

import okhttp3.Interceptor
import okhttp3.Response

private const val API_KEY_QUERY = "api-key"
private const val API_KEY_VALUE = "v1EqBIdvISahGf1rLgiAHvGruViDs3xP"

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url =
            original.url().newBuilder().addQueryParameter(API_KEY_QUERY, API_KEY_VALUE).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}