package com.kys.daggerhiltnytimes.framework.datasource.cache

import com.kys.daggerhiltnytimes.framework.datasource.cache.database.ResultDao
import com.kys.daggerhiltnytimes.framework.datasource.cache.model.ResultCacheEntity

class ResultDaoServiceImpl
constructor(
    private val resultDao: ResultDao
) : ResultDaoService {

    override suspend fun insert(resultEntity: ResultCacheEntity): Long {
        return resultDao.insert(resultEntity)
    }

    override suspend fun get(): List<ResultCacheEntity> {
        return resultDao.get()
    }
}