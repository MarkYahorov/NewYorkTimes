package com.example.wire.data.models.item

import com.google.gson.annotations.SerializedName

data class NewsWireItem(
    @SerializedName("slug_name")
    val id: String,
    @SerializedName("section")
    val section: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("abstract")
    val shortDescription: String,
    @SerializedName("thumbnail_standard")
    val previewImage: String?,
    @SerializedName("multimedia")
    val mediaList: List<MediaDto>?
)
