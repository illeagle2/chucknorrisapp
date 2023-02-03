package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.JokeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NorrisJokesApi {

    @GET("/jokes/random")
    suspend fun getJoke(): JokeDto

    @GET("/jokes/random")
    suspend fun getJokes(): JokeDto

    @GET("/jokes/random")
    suspend fun getTextJoke(
        @Query("name") text: String = "text"
    ): JokeDto

}