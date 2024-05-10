package kr.pe.ssun.template.core.ui

import kr.pe.ssun.template.core.model.Photo

sealed interface MainUiState {
    data class Success(
        val photos: List<Photo>
    ): MainUiState
    data object Loading: MainUiState
    data object Error: MainUiState
}