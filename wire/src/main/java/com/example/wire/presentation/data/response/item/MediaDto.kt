package com.example.wire.presentation.data.response.item

import com.google.gson.annotations.SerializedName

data class MediaDto(
    @SerializedName("url")
    val url: String
)