package com.example.database.databasetable.wire

import androidx.room.Insert
import androidx.room.Update
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.basedao.InsertDao
import com.example.database.databasetable.basedao.UpdateDao

interface BaseWireDao : InsertDao<WireDetailDto>, UpdateDao<WireDetailDto> {

    @Insert(entity = WireDetailDto::class)
    override suspend fun insertItem(item: WireDetailDto)

    @Update(entity = WireDetailDto::class)
    override suspend fun updateItem(item: WireDetailDto)
}