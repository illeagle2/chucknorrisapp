package com.plcoding.cryptocurrencyappyt.presentation.listjokes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_jokes.GetJokesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListJokeViewModel @Inject constructor(
    private val getJokesUseCase: GetJokesUseCase
) : ViewModel() {
    //using viewmodel to keep the UIState
    //other Business logic moved to use cases

    private val _state = mutableStateOf(ListJokesState())
    val state: State<ListJokesState> = _state

    init {
        getJokes()
    }

     fun getJokes() {
        getJokesUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = ListJokesState(jokes = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ListJokesState(error = result.message?: "An unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = ListJokesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}