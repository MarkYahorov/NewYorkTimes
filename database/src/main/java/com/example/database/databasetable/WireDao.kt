package com.example.database.databasetable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.database.data.ImageDto
import com.example.database.data.WIRE_TABLE_NAME
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.wire.BaseWireDao

@Dao
interface WireDao : BaseDao, BaseWireDao {

    @Query("SELECT * FROM $WIRE_TABLE_NAME WHERE slug_name = :id")
    suspend fun getItemById(id: String): WireDetailDto?

    @Insert(entity = ImageDto::class)
    suspend fun insertPhoto(item: ImageDto)

    @Update(entity = ImageDto::class)
    suspend fun updatePhoto(item: ImageDto)
}