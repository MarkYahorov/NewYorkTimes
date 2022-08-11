package com.example.database

import android.content.Context
import androidx.room.Room
import com.example.database.nydatabase.NYDatabase

const val NY_DATABASE_NAME = "NY_DATA_BASE"

class DataBaseCreator(
    private val context: Context,
) {

    private var database: NYDatabase? = null

    @Synchronized
    fun getDataBase(): NYDatabase {
        return database ?: Room.databaseBuilder(
            context,
            NYDatabase::class.java,
            NY_DATABASE_NAME
        ).build().apply {
            database = this
        }
    }
}