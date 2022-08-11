package com.example.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val IMAGE_TABLE_NAME = "wire_images"

@Entity(tableName = IMAGE_TABLE_NAME)
data class ImageDto(
    @PrimaryKey @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "wire_id") val wireId: String
): BaseDto
