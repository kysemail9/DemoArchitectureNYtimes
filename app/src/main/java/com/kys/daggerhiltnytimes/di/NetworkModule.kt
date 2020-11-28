package com.kys.daggerhiltnytimes.di

import com.kys.daggerhiltnytimes.business.data.network.NetworkDataSource
import com.kys.daggerhiltnytimes.business.data.network.NetworkDataSourceImpl
import com.kys.daggerhiltnytimes.framework.datasource.network.ResultRetrofitService
import com.kys.daggerhiltnytimes.framework.datasource.network.ResultRetrofitServiceImpl
import com.kys.daggerhiltnytimes.framework.datasource.network.mappers.NetworkMapper
import com.kys.daggerhiltnytimes.framework.datasource.network.retrofit.ResultRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kys.daggerhiltnytimes.utils.EmptyArrayConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("http://api.nytimes.com/")
            //.addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder): ResultRetrofit {
        return retrofit
            .build()
            .create(ResultRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideBlogRetrofitService(
        blogRetrofit: ResultRetrofit
    ): ResultRetrofitService {
        return ResultRetrofitServiceImpl(blogRetrofit)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(
        blogRetrofitService: ResultRetrofitService,
        networkMapper: NetworkMapper
    ): NetworkDataSource {
        return NetworkDataSourceImpl(blogRetrofitService, networkMapper)
    }

}




















