package com.kys.daggerhiltnytimes.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class Media(
	@SerializedName( "type") @Expose val type: String,
	@SerializedName("subtype") @Expose val subtype: String,
	@SerializedName( "caption") @Expose val caption: String,
	@SerializedName( "copyright") @Expose val copyright: String,
	@SerializedName("approved_for_syndication") @Expose val approved_for_syndication: Int,
	@SerializedName( "media-metadata") @Expose val media_metadata: List<MediaMetadata>
)