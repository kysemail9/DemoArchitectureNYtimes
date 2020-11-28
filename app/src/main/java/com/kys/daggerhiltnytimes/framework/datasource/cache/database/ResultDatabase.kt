package com.kys.daggerhiltnytimes.framework.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kys.daggerhiltnytimes.framework.datasource.cache.model.ResultCacheEntity

@Database(entities = [ResultCacheEntity::class ], version = 4)
abstract class ResultDatabase: RoomDatabase() {

    abstract fun resultDao(): ResultDao

    companion object{
        const val DATABASE_NAME: String = "result_db"
    }
}