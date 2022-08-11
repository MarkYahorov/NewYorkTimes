package com.example.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val WIRE_TABLE_NAME = "wire_table"

sealed interface BaseDto

@Entity(tableName = WIRE_TABLE_NAME)
data class WireDetailDto(
    @PrimaryKey @ColumnInfo(name = "slug_name") val id: String,
    @ColumnInfo(name = "section") val section: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "shortDescription") val shortDescription: String,
    @ColumnInfo(name = "previewImage") val previewImage: String?
) : BaseDto
