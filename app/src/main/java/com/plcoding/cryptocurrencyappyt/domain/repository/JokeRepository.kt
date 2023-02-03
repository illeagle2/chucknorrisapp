package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.JokeDto

interface JokeRepository {

    suspend fun getJoke(): JokeDto

    suspend fun getJokes(): JokeDto

    suspend fun getTextJoke(name: String): JokeDto
}