package com.example.wire.presentation.data.response.category

import com.google.gson.annotations.SerializedName

data class WireSectionItemDto(
    @SerializedName("section")
    val section: String,
    @SerializedName("display_name")
    val displayName: String
)
