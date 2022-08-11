package com.example.wire.presentation.data.response.category

import com.google.gson.annotations.SerializedName

data class WireSectionDto(
    @SerializedName("results")
   val categories: List<WireSectionItemDto>
)