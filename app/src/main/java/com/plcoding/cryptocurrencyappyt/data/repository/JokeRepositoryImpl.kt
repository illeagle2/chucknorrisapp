package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.remote.NorrisJokesApi
import com.plcoding.cryptocurrencyappyt.data.remote.dto.JokeDto
import com.plcoding.cryptocurrencyappyt.domain.repository.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val api: NorrisJokesApi
) : JokeRepository {

    override suspend fun getJoke(): JokeDto {
        return api.getJoke()
    }

    override suspend fun getJokes(): JokeDto {
        return api.getJokes()
    }

    override suspend fun getTextJoke(name: String): JokeDto {
        return api.getTextJoke(text = name)
    }
}