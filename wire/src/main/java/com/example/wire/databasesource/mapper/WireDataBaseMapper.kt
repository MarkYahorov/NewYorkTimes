package com.example.wire.databasesource.mapper

import com.example.core.mapper.SingleMapper
import com.example.database.data.WireDetailDto
import com.example.wire.presentation.data.presentation.WireItem
import javax.inject.Inject

class WireDataBaseMapper @Inject constructor() : SingleMapper<WireItem, WireDetailDto> {

    override fun map(input: WireItem): WireDetailDto {
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