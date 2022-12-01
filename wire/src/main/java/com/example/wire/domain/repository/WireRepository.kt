package com.example.wire.domain.repository

import com.example.wire.domain.models.DomainWireItem
import com.example.wire.domain.models.DomainCategory
import kotlinx.coroutines.flow.Flow

interface WireRepository {

    suspend fun getWireCategories(): Flow<List<DomainCategory>>

    suspend fun getWireContent(source: String, category: String): Flow<List<DomainWireItem>>
}