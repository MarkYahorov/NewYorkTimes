package com.example.wire.di.module

import com.example.core.ViewModelFactory
import com.example.core.producer.NetworkDataProducer
import com.example.database.daoprovider.DaoProvider
import com.example.database.databasetable.WireDao
import com.example.wire.data.databasesource.WireDataBaseSourceImpl
import com.example.wire.data.repository.WireRepositoryImpl
import com.example.wire.data.service.WireService
import com.example.wire.di.WireScope
import com.example.wire.domain.repository.WireDataBaseSource
import com.example.wire.domain.repository.WireRepository
import com.example.wire.presentation.viewmodel.WireViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [MappersModule::class])
interface WireModule {

    companion object {
        @WireScope
        @Provides
        fun provideWireService(networkDataProducer: NetworkDataProducer): WireService {
            return networkDataProducer.createService(WireService::class.java)
        }

        @WireScope
        @Provides
        fun provideWireDao(daoProvider: DaoProvider): WireDao {
            return daoProvider.getDao(WireDao::class.java)
        }
    }

    @WireScope
    @Binds
    fun provideWireRepository(repositoryImpl: WireRepositoryImpl): WireRepository

    @WireScope
    @Binds
    fun bindWireViewModelFactory(factory: WireViewModelFactory): ViewModelFactory

    @WireScope
    @Binds
    fun bindWireDataBaseSource(dataBaseSourceImpl: WireDataBaseSourceImpl): WireDataBaseSource
}