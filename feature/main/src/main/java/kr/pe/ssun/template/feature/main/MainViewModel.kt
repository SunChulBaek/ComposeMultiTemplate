package kr.pe.ssun.template.feature.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kr.pe.ssun.template.core.domain.GetPhotosParam
import kr.pe.ssun.template.core.domain.GetPhotosUseCase
import kr.pe.ssun.template.core.domain.model.DPhoto
import javax.inject.Inject

sealed interface MainUiState {
    object Loading: MainUiState
    object Error: MainUiState
    data class Success(val photos: List<DPhoto>): MainUiState
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductsUseCase: GetPhotosUseCase
) : ViewModel() {

    val mainUiState = MutableStateFlow<MainUiState>(MainUiState.Loading)

    fun getProduct() = viewModelScope.launch {
        try {
            getProductsUseCase(GetPhotosParam()).collect { result ->
                when {
                    result.isSuccess -> {
                        mainUiState.value = MainUiState.Success(result.getOrNull()?.photos!!)
                    }
                    result.isFailure -> {
                        mainUiState.value = MainUiState.Error
                    }
                }
            }
        } catch (e: Exception) {
            mainUiState.value = MainUiState.Error
        }
    }

    fun onClick(photo: DPhoto) {
        Log.d("MainViewModel", "[x1210x] onClick")
    }
}