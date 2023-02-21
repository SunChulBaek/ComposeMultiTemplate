package kr.pe.ssun.template.core.network.retrofit

import kotlinx.serialization.json.Json
import kr.pe.ssun.template.core.model.Photo
import kr.pe.ssun.template.core.network.SsunNetworkDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitSsunNetworkApi {

    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}

@Singleton
class RetrofitSsunNetwork @Inject constructor(
    networkJson: Json
) : SsunNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    // TODO: Decide logging logic
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitSsunNetworkApi::class.java)

    override suspend fun getPhotos(): List<Photo> = networkApi.getPhotos()
}