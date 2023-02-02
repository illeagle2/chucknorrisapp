package com.plcoding.cryptocurrencyappyt.presentation.randomjoke

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_joke.GetJokeUseCase
import com.plcoding.cryptocurrencyappyt.presentation.listjokes.ListJokesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RandomJokeViewModel @Inject constructor(
    private val getJokeUseCase: GetJokeUseCase
) : ViewModel() {
    //using viewmodel to keep the UIState
    //other Business logic moved to use cases

    private val _state = mutableStateOf(RandomJokeState())
    val state: State<RandomJokeState> = _state

    init {
        getJoke()
    }

    private fun getJoke() {
        getJokeUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = RandomJokeState(joke = result.data)
                }
                is Resource.Error -> {
                    _state.value = RandomJokeState(error = result.message?: "An unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = RandomJokeState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}