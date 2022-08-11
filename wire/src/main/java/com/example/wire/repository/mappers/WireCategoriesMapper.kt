package com.example.wire.repository.mappers

import com.example.core.mapper.SingleMapper
import com.example.wire.presentation.data.presentation.WireCategory
import com.example.wire.presentation.data.response.category.WireSectionDto
import com.example.wire.presentation.data.response.category.WireSectionItemDto
import javax.inject.Inject

class WireCategoriesMapper @Inject constructor() :
    SingleMapper<WireSectionDto, List<@JvmSuppressWildcards WireCategory>> {

    override fun map(input: WireSectionDto): List<WireCategory> {
        return input.categories.map {
            mapSectionItemToPresentation(it)
        }
    }

    private fun mapSectionItemToPresentation(itemDto: WireSectionItemDto): WireCategory {
        return with(itemDto) {
            WireCategory(section, displayName)
        }
    }
}