package com.example.wire.data.models.item

import com.google.gson.annotations.SerializedName

data class NewsWireDto(
    @SerializedName("results")
    val listResult: List<NewsWireItem>
)