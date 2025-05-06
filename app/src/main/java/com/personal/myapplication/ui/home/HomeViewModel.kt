package com.personal.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.myapplication.domain.usecase.CatsPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val catsPhotosUseCase: CatsPhotosUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    fun getPhotos() {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val result = catsPhotosUseCase.getPhotos()
            result.onSuccess {
                _state.update { currentState ->
                    currentState.copy(
                        photos = it.map { it.url ?: "" },
                        loading = false,
                        errorMessage = ""
                    )
                }
            }.onFailure {
                _state.update { currentState ->
                    currentState.copy(
                        photos = emptyList(),
                        loading = false,
                        errorMessage = it.message ?: "error message"
                    )
                }
            }
        }
    }

}

data class HomeState(
    val photos: List<String> = emptyList(),
    val errorMessage: String = "",
    val loading: Boolean = false
)