package com.example.wire.domain.repository

import com.example.wire.domain.models.DomainWireItem

interface WireDataBaseSource {

    suspend fun insertWireItem(wireItem: DomainWireItem)

    suspend fun updateWireItem(wireItem: DomainWireItem)

    suspend fun isItemContains(id: String): Boolean
}