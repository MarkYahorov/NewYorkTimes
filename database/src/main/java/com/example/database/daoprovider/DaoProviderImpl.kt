package com.example.database.daoprovider

import com.example.database.databasetable.BaseDao
import com.example.database.databasetable.DetailDao
import com.example.database.databasetable.WireDao
import com.example.database.nydatabase.NYDatabase
import javax.inject.Inject

class DaoProviderImpl @Inject constructor(private val database: NYDatabase) : DaoProvider {

    @Suppress("UNCHECKED_CAST")
    override fun <T : BaseDao> getDao(clazz: Class<out BaseDao>): T {
        return when (clazz) {
            WireDao::class -> database.getWireDao() as T
            DetailDao::class.java -> database.getDetailDao() as T
            else -> database.getWireDao() as T
        }
    }
}