package com.example.wire.di.module

import com.example.core.mapper.SingleMapper
import com.example.database.data.WireDetailDto
import com.example.wire.data.databasesource.mapper.WireDataBaseMapper
import com.example.wire.data.models.category.WireSectionDto
import com.example.wire.data.models.item.NewsWireDto
import com.example.wire.data.repository.mappers.WireCategoriesMapper
import com.example.wire.data.repository.mappers.WireContentMapper
import com.example.wire.di.WireScope
import com.example.wire.domain.models.DomainCategory
import com.example.wire.domain.models.DomainWireItem
import com.example.wire.presentation.data.presentation.WireCategory
import com.example.wire.presentation.data.presentation.WireItem
import com.example.wire.presentation.mapper.WirePresentationCategoryMapper
import com.example.wire.presentation.mapper.WirePresentationContentMapper
import dagger.Binds
import dagger.Module

@Module
interface MappersModule {

    @WireScope
    @Binds
    fun providesContentMapper(mapper: WireContentMapper): SingleMapper<NewsWireDto, List<DomainWireItem>>

    @WireScope
    @Binds
    fun provideCategoryMapper(mapper: WireCategoriesMapper): SingleMapper<WireSectionDto, List<DomainCategory>>

    @WireScope
    @Binds
    fun bindDataBaseMapper(mapper: WireDataBaseMapper): SingleMapper<DomainWireItem, WireDetailDto>

    @WireScope
    @Binds
    fun bindCategoryPresentationMapper(mapper: WirePresentationCategoryMapper): SingleMapper<List<DomainCategory>, List<WireCategory>>

    @WireScope
    @Binds
    fun bindContentPresentationMapper(mapper: WirePresentationContentMapper): SingleMapper<List<DomainWireItem>, List<WireItem>>
}