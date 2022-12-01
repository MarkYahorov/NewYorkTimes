package com.example.wire.data.repository

import com.example.core.mapper.SingleMapper
import com.example.wire.data.models.category.WireSectionDto
import com.example.wire.data.models.item.NewsWireDto
import com.example.wire.data.service.WireService
import com.example.wire.domain.models.DomainCategory
import com.example.wire.domain.models.DomainWireItem
import com.example.wire.domain.repository.WireRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class WireRepositoryImpl @Inject constructor(
    private val wireService: WireService,
    @JvmSuppressWildcards private val categoryMapper: SingleMapper<WireSectionDto, List<DomainCategory>>,
    @JvmSuppressWildcards private val contentMapper: SingleMapper<NewsWireDto, List<DomainWireItem>>
) : WireRepository {

    override suspend fun getWireCategories(): Flow<List<DomainCategory>> {
        return flow {
            val sections = wireService.getWireSections()
            emit(sections)
        }.map {
            categoryMapper.map(it)
        }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getWireContent(source: String, category: String): Flow<List<DomainWireItem>> {
        return flow {
            val content = wireService.getWireNews(source = source, section = category)
            emit(contentMapper.map(content))
        }
            .flowOn(Dispatchers.IO)
    }

}