package com.example.wire.databasesource

import com.example.wire.presentation.data.presentation.WireItem

interface WireDataBaseSource {

    suspend fun updateWire(wireItem: WireItem)
}