package com.example.database.daoprovider

import com.example.database.databasetable.BaseDao

interface DaoProvider {

    fun <T : BaseDao> getDao(clazz: Class<out BaseDao>): T
}