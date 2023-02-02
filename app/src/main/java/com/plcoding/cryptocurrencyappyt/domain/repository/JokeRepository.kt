package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.JokeDto

interface JokeRepository {

    suspend fun getJoke(): JokeDto

    suspend fun getJokes(): List<JokeDto>

    suspend fun getTextJoke(name: String): JokeDto
}