package kr.pe.ssun.template.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kr.pe.ssun.template.core.domain.GetPhotosUseCase
import kr.pe.ssun.template.core.ui.MainUiState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getProductsUseCase: GetPhotosUseCase
) : ViewModel() {

    val uiState = getProductsUseCase(null).map { result ->
        result.getOrNull()?.let { photos ->
            MainUiState.Success(photos)
        } ?: MainUiState.Error
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = MainUiState.Loading
    )
}