package com.example.database.databasetable

import androidx.room.Dao
import androidx.room.Query
import com.example.database.data.IMAGE_TABLE_NAME
import com.example.database.data.ImageDto
import com.example.database.data.WIRE_TABLE_NAME
import com.example.database.data.WireDetailDto

@Dao
interface DetailDao : BaseDao {

    @Query("SELECT * FROM $WIRE_TABLE_NAME WHERE slug_name = :id")
    suspend fun getItemById(id: String): WireDetailDto

    @Query("SELECT * FROM $IMAGE_TABLE_NAME WHERE wire_id = :detailId")
    suspend fun getPhotos(detailId: String): List<ImageDto>
}