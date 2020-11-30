package com.kys.daggerhiltnytimes.framework.datasource.cache.model

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@TypeConverters(RequestConverter::class)
@Entity(tableName = "results")
data class ResultCacheEntity(

    @ColumnInfo(name = "abstract") var abstract_detail: String = "",

    @ColumnInfo(name = "uri") var uri: String = "",
    @ColumnInfo(name = "url") var url: String = "",

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var id: Long = 0,

    @ColumnInfo(name = "asset_id") var asset_id: Long = 0,
    @ColumnInfo(name = "source") var source: String = "",
    @ColumnInfo(name = "published_date") var published_date: String = "",
    @ColumnInfo(name = "updated") var updated: String = "",
    @ColumnInfo(name = "section") var section: String = "",
    @ColumnInfo(name = "subsection") var subsection: String = "",
    @ColumnInfo(name = "nytdsection") var nytdsection: String = "",
    @ColumnInfo(name = "adx_keywords") var adx_adx_keywordswords: String = "",
    @ColumnInfo(name = "byline") var byline: String = "",
    @ColumnInfo(name = "type") var type: String = "",
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "media") var media: List<Media> = emptyList(),
    @ColumnInfo(name = "eta_id") var eta_id: Int = 0
) {

}


data class Media(
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "subtype") var subtype: String,
    @ColumnInfo(name = "caption") var caption: String,
    @ColumnInfo(name = "copyright") var copyright: String,
    @ColumnInfo(name = "approved_for_syndication") var approved_for_syndication: Int,
    @ColumnInfo(name = "media-metadata") var media_metadata: List<MediaMetadata>
)

data class MediaMetadata(
    @ColumnInfo(name = "url") var url: String,
    @ColumnInfo(name = "format") var format: String,
    @ColumnInfo(name = "height") var height: Int,
    @ColumnInfo(name = "width") var width: Int
)

class RequestConverter {
    @TypeConverter
    fun fromCountryLangList(value: List<Media>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Media>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCountryLangList(value: String): List<Media> {
        val gson = Gson()
        val type = object : TypeToken<List<Media>>() {}.type
        return gson.fromJson(value, type)
    }
}



