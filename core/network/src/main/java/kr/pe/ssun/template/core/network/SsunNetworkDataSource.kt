package kr.pe.ssun.template.core.network

import kr.pe.ssun.template.core.model.Photo

interface SsunNetworkDataSource {
    suspend fun getPhotos(): List<Photo>
}