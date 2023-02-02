package com.plcoding.cryptocurrencyappyt.presentation.listjokes

import com.plcoding.cryptocurrencyappyt.domain.model.Joke

data class ListJokesState(

    val isLoading: Boolean = false,
    val jokes: List<Joke> = emptyList(),
    val error: String = ""
)
