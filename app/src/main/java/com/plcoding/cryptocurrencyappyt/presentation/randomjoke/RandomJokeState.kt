package com.plcoding.cryptocurrencyappyt.presentation.randomjoke

import com.plcoding.cryptocurrencyappyt.domain.model.Joke

data class RandomJokeState(

    val isLoading: Boolean = false,
    val joke: Joke? = null,
    val error: String = ""
)
