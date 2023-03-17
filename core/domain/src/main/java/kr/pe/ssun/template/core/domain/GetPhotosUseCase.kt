package kr.pe.ssun.template.core.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.pe.ssun.template.core.data.respository.PhotosRepository
import kr.pe.ssun.template.core.model.Photo
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val photosRepository: PhotosRepository,
): FlowUseCase<Any?, List<Photo>>() {

    override fun execute(parameters: Any?): Flow<Result<List<Photo>>> =
        photosRepository.getPhotos().map { photos ->
            Result.success(photos)
        }
}