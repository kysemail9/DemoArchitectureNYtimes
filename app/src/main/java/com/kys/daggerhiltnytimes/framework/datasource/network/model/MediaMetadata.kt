package com.kys.daggerhiltnytimes.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class MediaMetadata(
	@SerializedName( "url") @Expose val url: String,
	@SerializedName("format") @Expose val format: String,
	@SerializedName("height") @Expose val height: Int,
	@SerializedName( "width") @Expose val width: Int
)