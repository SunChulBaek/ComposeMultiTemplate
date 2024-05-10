package kr.pe.ssun.template.core.data.respository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kr.pe.ssun.template.core.datastore.UserDataStore
import kr.pe.ssun.template.core.model.Photo
import kr.pe.ssun.template.core.network.SsunNetworkDataSource
import kr.pe.ssun.template.core.network.model.NetworkPhoto
import kr.pe.ssun.template.core.network.model.asExternalModel
import javax.inject.Inject

class DefaultProductsRepository @Inject constructor(
    private val network: SsunNetworkDataSource,
    private val dataStore: UserDataStore
) : PhotosRepository {
    override fun getPhotos(): Flow<List<Photo>> = combine(
        flow {
            emit(network.getPhotos().map(NetworkPhoto::asExternalModel))
        },
        dataStore.bookmarks
    ) { photos, bookmarks ->
        photos.map {
            it.copy(bookmarked = bookmarks.contains(it.id))
        }
    }

    override fun togleBookmark(id: Int): Flow<Boolean> = flow {
        emit(dataStore.toggle(id))
    }
}