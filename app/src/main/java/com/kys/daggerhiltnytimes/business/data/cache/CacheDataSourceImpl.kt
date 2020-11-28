package com.kys.daggerhiltnytimes.business.data.cache

import com.kys.daggerhiltnytimes.business.domain.models.Result
import com.kys.daggerhiltnytimes.framework.datasource.cache.ResultDaoService
import com.kys.daggerhiltnytimes.framework.datasource.cache.mappers.CacheMapper

class CacheDataSourceImpl
constructor(
    private val resultDaoService: ResultDaoService,
    private val cacheMapper: CacheMapper
) : CacheDataSource {

    override suspend fun insert(result: Result): Long {
        return resultDaoService.insert(cacheMapper.mapToEntity(result))
    }

    override suspend fun insertList(results: List<Result>) {
        for (result in results) {
            resultDaoService.insert(cacheMapper.mapToEntity(result))
        }
    }

    override suspend fun get(): List<Result> {
        return cacheMapper.mapFromEntityList(resultDaoService.get())
    }
}
