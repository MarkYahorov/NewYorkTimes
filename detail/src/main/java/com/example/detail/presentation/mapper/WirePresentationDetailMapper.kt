package com.example.detail.presentation.mapper

import com.example.core.mapper.SingleMapper
import com.example.detail.domain.models.DomainWireItem
import com.example.detail.presentation.data.WireDetail
import javax.inject.Inject

class WirePresentationDetailMapper @Inject constructor(): SingleMapper<DomainWireItem, WireDetail> {
    override fun map(input: DomainWireItem): WireDetail {
        return with(input) {
            WireDetail(
                section, title, shortDescription, previewImage, mediaList
            )
        }
    }
}