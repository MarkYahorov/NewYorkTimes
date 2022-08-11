package com.example.database.databasetable.basedao

interface UpdateDao<T: Any> {
    suspend fun updateItem(item: T)
}