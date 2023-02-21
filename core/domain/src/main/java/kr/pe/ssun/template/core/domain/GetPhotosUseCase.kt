package kr.pe.ssun.template.core.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.pe.ssun.template.core.data.respository.PhotosRepository
import kr.pe.ssun.template.core.domain.model.DPhoto
import javax.inject.Inject

class GetPhotosParam

data class GetPhotosResult(
    val photos: List<DPhoto>
)

class GetPhotosUseCase @Inject constructor(
    private val photosRepository: PhotosRepository,
): FlowUseCase<GetPhotosParam, GetPhotosResult>() {

    override fun execute(parameters: GetPhotosParam): Flow<Result<GetPhotosResult>> =
        photosRepository.getPhotos().map { response ->
            Result.success(GetPhotosResult(response.map { photo ->
                DPhoto(
                    albumId = photo.albumId,
                    id = photo.id,
                    title = photo.title,
                    url = photo.url,
                    thumbnailUrl = photo.thumbnailUrl,
                )
            }))
        }
}