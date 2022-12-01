package com.example.wire.data.models.category

import com.google.gson.annotations.SerializedName

data class WireSectionDto(
    @SerializedName("results")
   val categories: List<WireSectionItemDto>
)