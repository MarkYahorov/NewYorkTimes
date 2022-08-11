package com.example.wire.repository.mappers

import com.example.core.mapper.SingleMapper
import com.example.wire.presentation.data.presentation.WireItem
import com.example.wire.presentation.data.response.item.MediaDto
import com.example.wire.presentation.data.response.item.NewsWireDto
import com.example.wire.presentation.data.response.item.NewsWireItem
import javax.inject.Inject

class WireContentMapper @Inject constructor() :
    SingleMapper<NewsWireDto, List<@JvmSuppressWildcards WireItem>> {

    override fun map(input: NewsWireDto): List<WireItem> {
        return input.listResult.map {
            mapContentItemToPresentation(it)
        }
    }

    private fun mapContentItemToPresentation(item: NewsWireItem): WireItem {
        return with(item) {
            WireItem(
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