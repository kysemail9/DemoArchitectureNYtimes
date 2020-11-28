package com.kys.daggerhiltnytimes.framework.datasource.network

import com.kys.daggerhiltnytimes.framework.datasource.network.model.ArticleNetworkEntity
import com.kys.daggerhiltnytimes.framework.datasource.network.retrofit.ResultRetrofit

class ResultRetrofitServiceImpl
constructor(
    private val blogRetrofit: ResultRetrofit
) : ResultRetrofitService {

    override suspend fun get(): ArticleNetworkEntity {
        return blogRetrofit.get()
    }
}