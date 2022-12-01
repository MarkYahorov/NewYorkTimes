package com.example.wire.domain.models

data class DomainWireItem(
    val id: String,
    val section: String,
    val title: String,
    val shortDescription: String,
    val previewImage: String?,
    val mediaList: List<String>?
)
