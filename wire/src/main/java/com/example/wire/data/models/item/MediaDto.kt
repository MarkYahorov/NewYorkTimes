package com.example.wire.data.models.item

import com.google.gson.annotations.SerializedName

data class MediaDto(
    @SerializedName("url")
    val url: String
)