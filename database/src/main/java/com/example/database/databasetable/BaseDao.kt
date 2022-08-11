package com.example.database.databasetable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.database.data.IMAGE_TABLE_NAME
import com.example.database.data.ImageDto
import com.example.database.data.WIRE_TABLE_NAME
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.wire.BaseWireDao

sealed interface BaseDao