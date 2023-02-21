package kr.pe.ssun.template.core.network.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import kr.pe.ssun.template.core.network.SsunNetworkDataSource
import kr.pe.ssun.template.core.network.retrofit.RetrofitSsunNetwork
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface SsunNetworkModule {

    @Binds
    fun RetrofitSsunNetwork.binds(): SsunNetworkDataSource
}