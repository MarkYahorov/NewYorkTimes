package com.example.detail.databasesource

import com.example.detail.data.WireDetail
import kotlinx.coroutines.flow.Flow

interface DetailDataBaseSource {

    suspend fun getWireDetail(id: String): Flow<WireDetail>
}