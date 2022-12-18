package com.example.detail.presentation.data

data class WireDetail(
    val section: String = "",
    val title: String = "",
    val shortDescription: String = "",
    val previewImage: String? = null,
    val imagesList: List<String>? = emptyList()
)
