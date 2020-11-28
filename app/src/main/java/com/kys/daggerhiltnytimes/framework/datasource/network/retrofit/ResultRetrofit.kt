package com.kys.daggerhiltnytimes.framework.datasource.network.retrofit

import com.kys.daggerhiltnytimes.framework.datasource.network.model.ArticleNetworkEntity
import retrofit2.http.GET

interface ResultRetrofit {

    @GET("svc/mostpopular/v2/viewed/7.json?api-key=2Re9ny5y5q09jEcopJMVoGj2KowApfNC")
    suspend fun get(): ArticleNetworkEntity
}