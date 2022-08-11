package com.example.wire.presentation.data.presentation

data class WireCategory(
    val section: String,
    val name: String,
    var isSelected: Boolean = false
)