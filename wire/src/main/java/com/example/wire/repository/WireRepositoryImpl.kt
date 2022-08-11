package com.example.wire.repository

import com.example.core.mapper.SingleMapper
import com.example.wire.presentation.data.presentation.WireCategory
import com.example.wire.presentation.data.presentation.WireItem
import com.example.wire.presentation.data.response.category.WireSectionDto
import com.example.wire.presentation.data.response.item.NewsWireDto
import com.example.wire.service.WireService
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class WireRepositoryImpl @Inject constructor(
    private val wireService: WireService,
    @JvmSuppressWildcards private val categoryMapper: SingleMapper<WireSectionDto, List<WireCategory>>,
    @JvmSuppressWildcards private val contentMapper: SingleMapper<NewsWireDto, List<WireItem>>
) : WireRepository {

    override suspend fun getWireCategories(): Flow<List<WireCategory>> {
        return flow {
            val sections = wireService.getWireSections()
            emit(sections)
        }.map {
            categoryMapper.map(it)
        }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getWireContent(source: String, category: String): Flow<List<WireItem>> {
        return flow {
            val content = wireService.getWireNews(source = source, section = category)
            emit(contentMapper.map(content))
        }
            .flowOn(Dispatchers.IO)
    }

}