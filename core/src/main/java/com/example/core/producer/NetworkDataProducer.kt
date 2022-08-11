package com.example.core.producer

interface NetworkDataProducer {

    fun <T : Any> createService(clazz: Class<T>): T
}