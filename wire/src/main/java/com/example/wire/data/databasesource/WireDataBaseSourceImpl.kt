package com.example.wire.data.databasesource

import com.example.core.mapper.SingleMapper
import com.example.database.data.ImageDto
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.WireDao
import com.example.wire.domain.models.DomainWireItem
import com.example.wire.domain.repository.WireDataBaseSource
import javax.inject.Inject

class WireDataBaseSourceImpl @Inject constructor(
    private val wireDao: WireDao,
    private val daoMapper: SingleMapper<DomainWireItem, WireDetailDto>
) : WireDataBaseSource {

    override suspend fun updateWireItem(wireItem: DomainWireItem) {
        wireDao.updateItem(daoMapper.map(wireItem))
        wireItem.mediaList?.forEach {
            wireDao.updatePhoto(
                ImageDto(
                    wireId = wireItem.id,
                    image = it
                )
            )
        }
    }

    override suspend fun isItemContains(id: String): Boolean {
        return wireDao.getItemById(id) != null
    }

    override suspend fun insertWireItem(wireItem: DomainWireItem) {
        wireDao.insertItem(daoMapper.map(wireItem))
        wireItem.mediaList?.forEach {
            wireDao.insertPhoto(
                ImageDto(
                    wireId = wireItem.id,
                    image = it
                )
            )
        }
    }
}