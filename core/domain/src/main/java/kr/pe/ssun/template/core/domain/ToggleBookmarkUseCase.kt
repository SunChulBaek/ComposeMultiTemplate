package kr.pe.ssun.template.core.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.pe.ssun.template.core.data.respository.PhotosRepository
import javax.inject.Inject

class ToggleBookmarkUseCase @Inject constructor(
    private val photosRepository: PhotosRepository,
): FlowUseCase<Int, Unit>() {
    override fun execute(parameters: Int): Flow<Result<Unit>> =
        photosRepository.togleBookmark(parameters).map {
            Result.success(Unit)
        }
}