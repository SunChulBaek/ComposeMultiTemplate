package kr.pe.ssun.template.core.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import kotlinx.serialization.json.Json
import kr.pe.ssun.template.core.network.SsunNetworkDataSource
import kr.pe.ssun.template.core.network.model.NetworkPhoto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KtorSsunNetwork @Inject constructor(
    networkJson: Json
) : SsunNetworkDataSource {

    private val client = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            gson()
        }
        defaultRequest {
            url("https://jsonplaceholder.typicode.com/")
        }
    }

    override suspend fun getPhotos(): List<NetworkPhoto> = client.get("photos").body()
}