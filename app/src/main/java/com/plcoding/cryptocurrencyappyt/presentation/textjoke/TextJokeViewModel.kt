package com.plcoding.cryptocurrencyappyt.presentation.textjoke

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_joke.GetJokeUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_text_joke.GetTextJokeUseCase
import com.plcoding.cryptocurrencyappyt.presentation.listjokes.ListJokesState
import com.plcoding.cryptocurrencyappyt.presentation.randomjoke.RandomJokeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TextJokeViewModel @Inject constructor(
    private val getTextJokeUseCase: GetTextJokeUseCase
) : ViewModel() {
    //using viewmodel to keep the UIState
    //other Business logic moved to use cases

    private val _state = mutableStateOf(TextJokeState())
    val state: State<TextJokeState> = _state

    init {
        //getTextJoke("")
    }

     fun getTextJoke(name: String) {
        getTextJokeUseCase(name).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = TextJokeState(joke = result.data)
                }
                is Resource.Error -> {
                    _state.value = TextJokeState(error = result.message?: "An unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = TextJokeState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}