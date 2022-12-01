package com.example.wire.data.repository.mappers

import com.example.core.mapper.SingleMapper
import com.example.wire.data.models.item.MediaDto
import com.example.wire.data.models.item.NewsWireDto
import com.example.wire.data.models.item.NewsWireItem
import com.example.wire.domain.models.DomainWireItem
import javax.inject.Inject

class WireContentMapper @Inject constructor() :
    SingleMapper<NewsWireDto, List<@JvmSuppressWildcards DomainWireItem>> {

    override fun map(input: NewsWireDto): List<DomainWireItem> {
        return input.listResult.map {
            mapContentItemToPresentation(it)
        }
    }

    private fun mapContentItemToPresentation(item: NewsWireItem): DomainWireItem {
        return with(item) {
            DomainWireItem(
                id,
                section,
                title,
                shortDescription,
                previewImage,
                mediaList?.map { mapToMediaUrl(it) }
            )
        }
    }

    private fun mapToMediaUrl(mediaItem: MediaDto): String {
        return mediaItem.url
    }
}