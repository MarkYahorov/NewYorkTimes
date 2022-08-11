package com.example.wire.di.module

import com.example.core.ViewModelFactory
import com.example.core.mapper.SingleMapper
import com.example.core.producer.NetworkDataProducer
import com.example.database.daoprovider.DaoProvider
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.DetailDao
import com.example.database.databasetable.WireDao
import com.example.wire.databasesource.WireDataBaseSource
import com.example.wire.databasesource.WireDataBaseSourceImpl
import com.example.wire.databasesource.mapper.WireDataBaseMapper
import com.example.wire.di.WireScope
import com.example.wire.presentation.data.presentation.WireCategory
import com.example.wire.presentation.data.presentation.WireItem
import com.example.wire.presentation.data.response.category.WireSectionDto
import com.example.wire.presentation.data.response.item.NewsWireDto
import com.example.wire.presentation.viewmodel.WireViewModelFactory
import com.example.wire.repository.WireRepository
import com.example.wire.repository.WireRepositoryImpl
import com.example.wire.repository.mappers.WireCategoriesMapper
import com.example.wire.repository.mappers.WireContentMapper
import com.example.wire.service.WireService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
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
    fun providesContentMapper(mapper: WireContentMapper): SingleMapper<NewsWireDto, List<WireItem>>

    @WireScope
    @Binds
    fun provideCategoryMapper(mapper: WireCategoriesMapper): SingleMapper<WireSectionDto, List<WireCategory>>

    @WireScope
    @Binds
    fun provideWireRepository(repositoryImpl: WireRepositoryImpl): WireRepository

    @WireScope
    @Binds
    fun bindWireViewModelFactory(factory: WireViewModelFactory): ViewModelFactory

    @WireScope
    @Binds
    fun bindWireDataBaseSource(dataBaseSourceImpl: WireDataBaseSourceImpl): WireDataBaseSource

    @WireScope
    @Binds
    fun bindDataBaseMapper(mapper: WireDataBaseMapper): SingleMapper<WireItem, WireDetailDto>
}