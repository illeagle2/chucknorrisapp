package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.data.remote.NorrisJokesApi
import com.plcoding.cryptocurrencyappyt.data.repository.JokeRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.repository.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNorrisJokesApi(): NorrisJokesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NorrisJokesApi::class.java)
    }

    @Provides
    @Singleton
    fun providesJokeRepository(api: NorrisJokesApi): JokeRepository{
        return JokeRepositoryImpl(api)
    }
}