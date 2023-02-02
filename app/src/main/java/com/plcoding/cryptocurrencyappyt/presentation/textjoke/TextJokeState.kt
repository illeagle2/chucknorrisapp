package com.plcoding.cryptocurrencyappyt.presentation.textjoke

import com.plcoding.cryptocurrencyappyt.domain.model.Joke

data class TextJokeState(

    val isLoading: Boolean = false,
    val joke: Joke? = null,
    val error: String = ""
)
