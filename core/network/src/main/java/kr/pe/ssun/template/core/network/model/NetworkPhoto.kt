package kr.pe.ssun.template.core.network.model

import kr.pe.ssun.template.core.model.Photo

data class NetworkPhoto(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
)

fun NetworkPhoto.asExternalModel() = Photo(
    albumId = this.albumId,
    id = this.id,
    title = this.title,
    url = this.url,
    thumbnailUrl = this.thumbnailUrl,
)