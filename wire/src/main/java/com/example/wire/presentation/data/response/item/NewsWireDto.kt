package com.example.wire.presentation.data.response.item

import com.google.gson.annotations.SerializedName

data class NewsWireDto(
    @SerializedName("results")
    val listResult: List<NewsWireItem>
)