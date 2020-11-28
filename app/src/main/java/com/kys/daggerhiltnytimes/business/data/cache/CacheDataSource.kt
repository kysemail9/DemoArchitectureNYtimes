package com.kys.daggerhiltnytimes.business.data.cache

import com.kys.daggerhiltnytimes.business.domain.models.Result

interface CacheDataSource {

    suspend fun insert(result: Result): Long

    suspend fun insertList(result: List<Result>)

    suspend fun get(): List<Result>
}