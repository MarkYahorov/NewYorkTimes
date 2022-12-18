package com.example.detail.data.databasesource

import com.example.core.mapper.TwiceMapper
import com.example.database.data.ImageDto
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.DetailDao
import com.example.detail.domain.DetailDataBaseSource
import com.example.detail.domain.models.DomainWireItem
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailDataBaseSourceImpl @Inject constructor(
    private val detailDao: DetailDao,
    @JvmSuppressWildcards private val mapper: TwiceMapper<WireDetailDto, List<ImageDto>, DomainWireItem>
) : DetailDataBaseSource {
    override suspend fun getWireDetail(id: String): Flow<DomainWireItem> {
        return flow {
            val detailDto = detailDao.getItemById(id)
            val images = detailDao.getPhotos(id)
            emit(mapper.map(detailDto, images))
        }
    }
}