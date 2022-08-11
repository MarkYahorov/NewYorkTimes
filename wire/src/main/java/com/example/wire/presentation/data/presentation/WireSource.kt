package com.example.wire.presentation.data.presentation

import androidx.annotation.StringRes
import com.example.wire.R

private const val ALL_REQUEST_NAME = "all"
private const val NYT_REQUEST_NAME = "nyt"
private const val INYT_REQUEST_NAME = "inyt"

enum class WireSource(@StringRes val descriptionId: Int, val requestName: String) {
    ALL(R.string.wire_source_all_description, ALL_REQUEST_NAME),
    NYT(R.string.wire_source_nyt_description, NYT_REQUEST_NAME),
    INYT(R.string.wire_source_inyt_description, INYT_REQUEST_NAME)
}