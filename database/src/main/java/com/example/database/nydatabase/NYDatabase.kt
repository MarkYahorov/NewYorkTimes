package com.example.database.nydatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.data.ImageDto
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.DetailDao
import com.example.database.databasetable.WireDao

private const val DATA_BASE_VERSION = 1

@Database(entities = [WireDetailDto::class, ImageDto::class], version = DATA_BASE_VERSION)
abstract class NYDatabase : RoomDatabase() {

    abstract fun getWireDao(): WireDao
    abstract fun getDetailDao(): DetailDao
}