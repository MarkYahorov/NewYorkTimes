package com.example.wire.domain.usecase

import com.example.wire.domain.models.DomainCategory
import com.example.wire.domain.models.DomainWireItem
import com.example.wire.domain.repository.WireDataBaseSource
import com.example.wire.domain.repository.WireRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class WireUseCase @Inject constructor(
    private val repository: WireRepository,
    private val wireDataBaseSource: WireDataBaseSource
) {

    suspend fun getCategories(): Flow<List<DomainCategory>> {
        return repository.getWireCategories()
    }

    suspend fun getContentList(source: String, category: String): Flow<List<DomainWireItem>> {
        return repository.getWireContent(source, category)
    }

    suspend fun updateWire(wireItem: DomainWireItem) {
        if (wireDataBaseSource.isItemContains(wireItem.id)) {
            wireDataBaseSource.updateWireItem(wireItem)
        } else {
            wireDataBaseSource.insertWireItem(wireItem)
        }
    }
}