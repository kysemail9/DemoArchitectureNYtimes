package com.kys.daggerhiltnytimes.framework.datasource.cache

import com.kys.daggerhiltnytimes.framework.datasource.cache.model.ResultCacheEntity

interface ResultDaoService {

    suspend fun insert(resultEntity: ResultCacheEntity): Long

    suspend fun get(): List<ResultCacheEntity>

}