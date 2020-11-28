package com.kys.daggerhiltnytimes.di

import com.kys.daggerhiltnytimes.business.data.cache.CacheDataSource
import com.kys.daggerhiltnytimes.business.data.network.NetworkDataSource
import com.kys.daggerhiltnytimes.business.interactors.GetResults
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideGetBlogs(
        cacheDataSource: CacheDataSource,
        networkDataSource: NetworkDataSource

    ): GetResults {
        return GetResults(cacheDataSource, networkDataSource)
    }
}














