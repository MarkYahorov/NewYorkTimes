package com.example.wire.presentation.mapper

import com.example.core.mapper.SingleMapper
import com.example.wire.domain.models.DomainWireItem
import com.example.wire.presentation.data.presentation.WireItem
import javax.inject.Inject

class WirePresentationContentMapper @Inject constructor() :
    SingleMapper<List<@JvmSuppressWildcards DomainWireItem>, List<@JvmSuppressWildcards WireItem>> {
    override fun map(input: List<DomainWireItem>): List<WireItem> {
        return input.map {
            WireItem(
                id = it.id,
                section = it.section,
                mediaList = it.mediaList,
                title = it.title,
                previewImage = it.previewImage,
                shortDescription = it.shortDescription
            )
        }
    }
}