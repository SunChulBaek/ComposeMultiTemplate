package kr.pe.ssun.template.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.pe.ssun.template.core.data.respository.DefaultProductsRepository
import kr.pe.ssun.template.core.data.respository.PhotosRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsProductsRepository(
        productsRepository: DefaultProductsRepository
    ) : PhotosRepository
}