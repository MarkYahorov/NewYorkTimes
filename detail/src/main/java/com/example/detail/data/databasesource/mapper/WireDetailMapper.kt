package com.example.detail.data.databasesource.mapper

import com.example.core.mapper.TwiceMapper
import com.example.database.data.ImageDto
import com.example.database.data.WireDetailDto
import com.example.detail.domain.models.DomainWireItem
import javax.inject.Inject

class WireDetailMapper @Inject constructor() :
    TwiceMapper<WireDetailDto, List<@JvmSuppressWildcards ImageDto>, DomainWireItem> {

    override fun map(firstInput: WireDetailDto, secondInput: List<ImageDto>): DomainWireItem {
        return with(firstInput) {
            DomainWireItem(
                section = section,
                title = title,
                shortDescription = shortDescription,
                previewImage = previewImage,
                mediaList = getImagesUrl(secondInput),
            )
        }
    }

    private fun getImagesUrl(secondInput: List<ImageDto>): List<String> {
        return secondInput.map { it.image }
    }
}