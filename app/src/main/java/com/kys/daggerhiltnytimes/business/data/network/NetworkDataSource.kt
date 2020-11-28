package com.kys.daggerhiltnytimes.business.data.network

import com.kys.daggerhiltnytimes.business.domain.models.Result

interface NetworkDataSource {

    suspend fun get(): List<Result>
}