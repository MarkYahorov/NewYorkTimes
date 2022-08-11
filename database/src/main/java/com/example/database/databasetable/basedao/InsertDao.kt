package com.example.database.databasetable.basedao

import com.example.database.data.BaseDto

interface InsertDao<T : BaseDto> {

    suspend fun insertItem(item: T)
}