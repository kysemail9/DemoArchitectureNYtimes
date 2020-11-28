package com.kys.daggerhiltnytimes.di

import android.content.Context
import androidx.room.Room
import com.kys.daggerhiltnytimes.business.data.cache.CacheDataSource
import com.kys.daggerhiltnytimes.business.data.cache.CacheDataSourceImpl
import com.kys.daggerhiltnytimes.framework.datasource.cache.ResultDaoService
import com.kys.daggerhiltnytimes.framework.datasource.cache.ResultDaoServiceImpl
import com.kys.daggerhiltnytimes.framework.datasource.cache.database.ResultDao
import com.kys.daggerhiltnytimes.framework.datasource.cache.database.ResultDatabase
import com.kys.daggerhiltnytimes.framework.datasource.cache.mappers.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): ResultDatabase {
        return Room
            .databaseBuilder(
                context,
                ResultDatabase::class.java,
                ResultDatabase.DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(resultDatabase: ResultDatabase): ResultDao {
        return resultDatabase.resultDao()
    }

    @Singleton
    @Provides
    fun provideBlogDaoService(
        resultDao: ResultDao
    ): ResultDaoService {
        return ResultDaoServiceImpl(resultDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(
        resultDaoService: ResultDaoService,
        cacheMapper: CacheMapper
    ): CacheDataSource {
        return CacheDataSourceImpl(resultDaoService, cacheMapper)
    }

}

























