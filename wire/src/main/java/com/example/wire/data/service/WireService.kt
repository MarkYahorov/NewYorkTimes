package com.example.wire.data.service

import com.example.wire.data.models.category.WireSectionDto
import com.example.wire.data.models.item.NewsWireDto
import retrofit2.http.GET
import retrofit2.http.Path

private const val WIRE_SOURCE = "source"
private const val WIRE_SECTION = "section"

interface WireService {

    @GET("news/v3/content/{$WIRE_SOURCE}/{$WIRE_SECTION}.json?limit=500")
    suspend fun getWireNews(
        @Path(WIRE_SOURCE) source: String,
        @Path(WIRE_SECTION) section: String
    ): NewsWireDto

    @GET("news/v3/content/section-list.json")
    suspend fun getWireSections(): WireSectionDto
}