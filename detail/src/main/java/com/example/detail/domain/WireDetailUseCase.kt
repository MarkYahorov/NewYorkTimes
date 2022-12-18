package com.example.detail.domain

import com.example.detail.domain.models.DomainWireItem
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class WireDetailUseCase @Inject constructor(private val dataBaseSource: DetailDataBaseSource) {

    suspend fun getWireDetailItem(id: String): Flow<DomainWireItem> {
        return dataBaseSource.getWireDetail(id)
    }
}