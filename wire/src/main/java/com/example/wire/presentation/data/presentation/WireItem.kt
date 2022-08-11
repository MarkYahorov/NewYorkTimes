package com.example.wire.presentation.data.presentation

data class WireItem(
    val id: String,
    val section: String,
    val title: String,
    val shortDescription: String,
    val previewImage: String?,
    val mediaList: List<String>?
)