package com.kys.daggerhiltnytimes.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ArticleNetworkEntity(

    @SerializedName("status")
    @Expose
    val status: String,

    @SerializedName("copyright")
    @Expose
    val copyright: String,

    @SerializedName("num_results")
    @Expose
    val num_results: Int,

    @SerializedName("results")
    @Expose
    val results: List<NetworkResult>
)