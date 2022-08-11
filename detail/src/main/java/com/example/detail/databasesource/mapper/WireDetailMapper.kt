package com.example.detail.databasesource.mapper

import com.example.core.mapper.TwiceMapper
import com.example.database.data.ImageDto
import com.example.database.data.WireDetailDto
import com.example.detail.data.WireDetail
import javax.inject.Inject

class WireDetailMapper @Inject constructor() :
    TwiceMapper<WireDetailDto, List<@JvmSuppressWildcards ImageDto>, WireDetail> {

    override fun map(firstInput: WireDetailDto, secondInput: List<ImageDto>): WireDetail {
        return with(firstInput) {
            WireDetail(
                section = section,
                title = title,
                shortDescription = shortDescription,
                previewImage = previewImage,
                getImagesUrl(secondInput)
            )
        }
    }

    private fun getImagesUrl(secondInput: List<ImageDto>): List<String> {
        return secondInput.map { it.image }
    }
}