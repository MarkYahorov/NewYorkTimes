package com.example.detail.domain

import com.example.detail.domain.models.DomainWireItem
import kotlinx.coroutines.flow.Flow

interface DetailDataBaseSource {

    suspend fun getWireDetail(id: String): Flow<DomainWireItem>
}