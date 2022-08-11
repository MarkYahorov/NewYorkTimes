package com.example.network.di.component

import com.example.core.producer.NetworkDataProducer
import com.example.network.di.module.NetworkModule
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    companion object {
        private var component: NetworkComponent? = null

        fun init(): NetworkComponent {
            return component ?: DaggerNetworkComponent.factory().create().apply { component = this }
        }

        fun clear() {
            component = null
        }
    }

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }

    fun provideNetworkProducer(): NetworkDataProducer
}