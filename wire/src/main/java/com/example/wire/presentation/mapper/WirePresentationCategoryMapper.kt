package com.example.wire.presentation.mapper

import com.example.core.mapper.SingleMapper
import com.example.wire.domain.models.DomainCategory
import com.example.wire.presentation.data.presentation.WireCategory
import javax.inject.Inject

class WirePresentationCategoryMapper @Inject constructor() :
    SingleMapper<List<@JvmSuppressWildcards DomainCategory>, List<@JvmSuppressWildcards WireCategory>> {

    override fun map(input: List<DomainCategory>): List<WireCategory> {
        return input.map {
            WireCategory(
                section = it.section,
                name = it.name
            )
        }
    }
}