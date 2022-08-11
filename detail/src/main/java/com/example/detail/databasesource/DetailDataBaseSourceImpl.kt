package com.example.detail.databasesource

import com.example.core.mapper.TwiceMapper
import com.example.database.data.ImageDto
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.DetailDao
import com.example.detail.data.WireDetail
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailDataBaseSourceImpl @Inject constructor(
    private val detailDao: DetailDao,
    @JvmSuppressWildcards private val mapper: TwiceMapper<WireDetailDto, List<ImageDto>, WireDetail>
) : DetailDataBaseSource {
    override suspend fun getWireDetail(id: String): Flow<WireDetail> {
        return flow {
            val detailDto = detailDao.getItemById(id)
            val images = detailDao.getPhotos(id)
            emit(mapper.map(detailDto, images))
        }
    }
}