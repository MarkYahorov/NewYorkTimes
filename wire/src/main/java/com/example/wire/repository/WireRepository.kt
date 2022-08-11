package com.example.wire.repository

import com.example.wire.presentation.data.presentation.WireCategory
import com.example.wire.presentation.data.presentation.WireItem
import kotlinx.coroutines.flow.Flow

interface WireRepository {

    suspend fun getWireCategories(): Flow<List<WireCategory>>

    suspend fun getWireContent(source: String, category: String): Flow<List<WireItem>>
}