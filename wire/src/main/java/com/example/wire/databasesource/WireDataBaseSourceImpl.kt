package com.example.wire.databasesource

import com.example.core.mapper.SingleMapper
import com.example.database.data.ImageDto
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.WireDao
import com.example.wire.presentation.data.presentation.WireItem
import javax.inject.Inject

class WireDataBaseSourceImpl @Inject constructor(
    private val wireDao: WireDao,
    private val daoMapper: SingleMapper<WireItem, WireDetailDto>
) : WireDataBaseSource {
    override suspend fun updateWire(wireItem: WireItem) {
        val daoItem = wireDao.getItemById(wireItem.id)
        if (daoItem != null) {
            wireDao.updateItem(daoMapper.map(wireItem))
            wireItem.mediaList?.forEach {
                updateImageDto(wireId = wireItem.id, it)
            }

        } else {
            wireDao.insertItem(daoMapper.map(wireItem))
            wireItem.mediaList?.forEach {
                insertImageDto(wireId = wireItem.id, image = it)
            }
        }
    }

    private suspend fun insertImageDto(wireId: String, image: String) {
        wireDao.insertPhoto(
            ImageDto(
                wireId = wireId,
                image = image
            )
        )
    }

    private suspend fun updateImageDto(wireId: String, image: String) {
        wireDao.updatePhoto(
            ImageDto(
                wireId = wireId,
                image = image
            )
        )
    }
}