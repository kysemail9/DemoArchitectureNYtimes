package com.kys.daggerhiltnytimes.framework.datasource.network

import com.kys.daggerhiltnytimes.framework.datasource.network.model.ArticleNetworkEntity

interface ResultRetrofitService {
    suspend fun get(): ArticleNetworkEntity
}