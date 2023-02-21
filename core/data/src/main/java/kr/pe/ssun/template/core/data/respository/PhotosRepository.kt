package kr.pe.ssun.template.core.data.respository

import kotlinx.coroutines.flow.Flow
import kr.pe.ssun.template.core.model.Photo

interface PhotosRepository {

    fun getPhotos(): Flow<List<Photo>>
}