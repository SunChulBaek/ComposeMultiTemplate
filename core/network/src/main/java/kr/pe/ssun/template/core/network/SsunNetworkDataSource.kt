package kr.pe.ssun.template.core.network

import kr.pe.ssun.template.core.network.model.NetworkPhoto

interface SsunNetworkDataSource {
    suspend fun getPhotos(): List<NetworkPhoto>
}