package com.example.detail.domain.models

data class DomainWireItem(
    val section: String,
    val title: String,
    val shortDescription: String,
    val previewImage: String?,
    val mediaList: List<String>?
)