package kr.pe.ssun.template.core.data.respository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.pe.ssun.template.core.model.Photo
import kr.pe.ssun.template.core.network.SsunNetworkDataSource
import javax.inject.Inject

class DefaultProductsRepository @Inject constructor(
    private val network: SsunNetworkDataSource
) : PhotosRepository {

    override fun getPhotos(): Flow<List<Photo>> = flow {
        emit(network.getPhotos())
    }
}