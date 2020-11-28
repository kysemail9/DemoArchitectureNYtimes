package com.kys.daggerhiltnytimes.business.domain.models


data class Result(
    val uri: String,
    val url: String,
    val id: Long,
    val asset_id: Long,
    val source: String,
    val published_date: String,
    val updated: String,
    val section: String,
    val subsection: String,
    val nytdsection: String,
    val adx_adx_keywordswords: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract_detail: String,
    val media: List<MediaItem>,
    val eta_id: Int
)

data class MediaItem(
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String,
    val approved_for_syndication: Int,
    val media_metadata: List<MediaMetadataItem>
)

data class MediaMetadataItem(
    val url: String,
    val format: String,
    val height: Int,
    val width: Int
)



