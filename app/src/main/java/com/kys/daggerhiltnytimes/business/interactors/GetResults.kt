package com.kys.daggerhiltnytimes.business.interactors

import com.kys.daggerhiltnytimes.business.data.cache.CacheDataSource
import com.kys.daggerhiltnytimes.business.data.network.NetworkDataSource
import com.kys.daggerhiltnytimes.business.domain.models.Result
import com.kys.daggerhiltnytimes.business.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetResults
constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
) {

    private val TAG: String = "AppDebug"

    /**
     * Show loading
     * 1. Get results from network
     * 2. Insert results into cache
     * 3. Show List<Results>
     */
    suspend fun execute(): Flow<DataState<List<Result>>> = flow {

        emit(DataState.Loading)

        delay(1000)

        val networkResults = networkDataSource.get()

        cacheDataSource.insertList(networkResults)

        val cachedResults = cacheDataSource.get()

        emit(DataState.Success(cachedResults))
    }

}
















