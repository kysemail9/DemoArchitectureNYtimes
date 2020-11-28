package com.kys.daggerhiltnytimes.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NetworkResult(
    @SerializedName("uri") @Expose val uri: String,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("id") @Expose val id: Long,
    @SerializedName("asset_id") @Expose val asset_id: Long,
    @SerializedName("source") @Expose val source: String,
    @SerializedName("published_date") @Expose val published_date: String,
    @SerializedName("updated") @Expose val updated: String,
    @SerializedName("section") @Expose val section: String,
    @SerializedName("subsection") @Expose val subsection: String,
    @SerializedName("nytdsection") @Expose val nytdsection: String,
    @SerializedName("adx_keywords") @Expose val adx_adx_keywordswords: String,
    @SerializedName("byline") @Expose val byline: String,
    @SerializedName("type") @Expose val type: String,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("abstract") @Expose val abstract: String,
    @SerializedName("media") @Expose val media: List<Media>,
    @SerializedName("eta_id") @Expose val eta_id: Int
)