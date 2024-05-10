package kr.pe.ssun.template.core.network.retrofit

import kr.pe.ssun.template.core.network.SsunNetworkDataSource
import kr.pe.ssun.template.core.network.model.NetworkPhoto
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

interface RetrofitSsunNetworkApi {
    @GET("photos")
    suspend fun getPhotos(): List<NetworkPhoto>
}

@Singleton
class RetrofitSsunNetwork @Inject constructor(
    private val networkApi: RetrofitSsunNetworkApi
) : SsunNetworkDataSource {

    override suspend fun getPhotos(): List<NetworkPhoto> = networkApi.getPhotos()
}