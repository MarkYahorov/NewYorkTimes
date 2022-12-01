package com.example.wire.data.repository.mappers

import com.example.core.mapper.SingleMapper
import com.example.wire.data.models.category.WireSectionDto
import com.example.wire.data.models.category.WireSectionItemDto
import com.example.wire.domain.models.DomainCategory
import javax.inject.Inject

class WireCategoriesMapper @Inject constructor() :
    SingleMapper<WireSectionDto, List<@JvmSuppressWildcards DomainCategory>> {

    override fun map(input: WireSectionDto): List<DomainCategory> {
        return input.categories.map {
            mapSectionItemToPresentation(it)
        }
    }

    private fun mapSectionItemToPresentation(itemDto: WireSectionItemDto): DomainCategory {
        return with(itemDto) {
            DomainCategory(section, displayName)
        }
    }
}