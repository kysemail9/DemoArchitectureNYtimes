package com.kys.daggerhiltnytimes.framework.datasource.network.mappers

import com.kys.daggerhiltnytimes.business.domain.models.MediaItem
import com.kys.daggerhiltnytimes.business.domain.models.MediaMetadataItem
import com.kys.daggerhiltnytimes.business.domain.models.Result
import com.kys.daggerhiltnytimes.business.domain.util.EntityMapper
import com.kys.daggerhiltnytimes.framework.datasource.network.model.Media
import com.kys.daggerhiltnytimes.framework.datasource.network.model.MediaMetadata
import com.kys.daggerhiltnytimes.framework.datasource.network.model.NetworkResult
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<NetworkResult, Result> {

    override fun mapFromEntity(entity: NetworkResult): Result {
        return Result(
            uri = entity.uri,
            url = entity.url,
            id = entity.id,
            asset_id = entity.asset_id,
            source = entity.source,
            published_date = entity.published_date,
            updated = entity.updated,
            section = entity.section,
            subsection = entity.subsection,
            nytdsection = entity.nytdsection,
            adx_adx_keywordswords = entity.adx_adx_keywordswords,
            byline = entity.byline,
            type = entity.type,
            title = entity.title,
            abstract_detail = entity.abstract,
            media = mapFromEntityListResultMedia(entity.media),
            eta_id = entity.eta_id
        )
    }

    override fun mapToEntity(domainModel: Result): NetworkResult {
        return NetworkResult(
            uri = domainModel.uri,
            url = domainModel.url,
            id = domainModel.id,
            asset_id = domainModel.asset_id,
            source = domainModel.source,
            published_date = domainModel.published_date,
            updated = domainModel.updated,
            section = domainModel.section,
            subsection = domainModel.subsection,
            nytdsection = domainModel.nytdsection,
            adx_adx_keywordswords = domainModel.adx_adx_keywordswords,
            byline = domainModel.byline,
            type = domainModel.type,
            title = domainModel.title,
            abstract = domainModel.abstract_detail,
            media = mapToEntityListResultMedia(domainModel.media),
            eta_id = domainModel.eta_id
        )
    }

    private fun mapFromEntityResultMedia(entity: Media): MediaItem {
        return MediaItem(
            type = entity.type,
            subtype = entity.subtype,
            caption = entity.caption,
            copyright = entity.copyright,
            approved_for_syndication = entity.approved_for_syndication,
            media_metadata = mapFromEntityListResultMediaMetadata(entity.media_metadata)
        )
    }

    private fun mapToEntityResultMedia(domainModel: MediaItem): Media {
        return Media(
            type = domainModel.type,
            subtype = domainModel.subtype,
            caption = domainModel.caption,
            copyright = domainModel.copyright,
            approved_for_syndication = domainModel.approved_for_syndication,
            media_metadata = mapToEntityListResultMediaMetadata(domainModel.media_metadata)
        )
    }

    private fun mapFromEntityResultMediaMetadata(entity: MediaMetadata): MediaMetadataItem {
        return MediaMetadataItem(
            url = entity.url,
            format = entity.format,
            height = entity.height,
            width = entity.width
        )
    }

    private fun mapToEntityResultMediaMetadata(domainModel: MediaMetadataItem): MediaMetadata {
        return MediaMetadata(
            url = domainModel.url,
            format = domainModel.format,
            height = domainModel.height,
            width = domainModel.width
        )
    }

    fun mapFromEntityList(entities: List<NetworkResult>): List<Result> {
        return entities.map { mapFromEntity(it) }
    }

    // map result -> media
    private fun mapFromEntityListResultMedia(entities: List<Media>): List<MediaItem> {
        return entities.map { mapFromEntityResultMedia(it) }
    }

    private fun mapToEntityListResultMedia(entities: List<MediaItem>): List<Media> {
        return entities.map { mapToEntityResultMedia(it) }
    }

    // map result -> media -> metadata
    private fun mapFromEntityListResultMediaMetadata(entities: List<MediaMetadata>): List<MediaMetadataItem> {
        return entities.map { mapFromEntityResultMediaMetadata(it) }
    }

    private fun mapToEntityListResultMediaMetadata(entities: List<MediaMetadataItem>): List<MediaMetadata> {
        return entities.map { mapToEntityResultMediaMetadata(it) }
    }
}





















