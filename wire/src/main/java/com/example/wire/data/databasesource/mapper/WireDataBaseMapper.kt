package com.example.wire.data.databasesource.mapper

import com.example.core.mapper.SingleMapper
import com.example.database.data.WireDetailDto
import com.example.wire.domain.models.DomainWireItem
import javax.inject.Inject

class WireDataBaseMapper @Inject constructor() : SingleMapper<DomainWireItem, WireDetailDto> {

    override fun map(input: DomainWireItem): WireDetailDto {
        return with(input) {
            WireDetailDto(
                id = id,
                section = section,
                title = title,
                shortDescription = shortDescription,
                previewImage = previewImage
            )
        }
    }
}