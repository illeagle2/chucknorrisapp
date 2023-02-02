package com.plcoding.cryptocurrencyappyt.domain.use_case.get_joke

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toJoke
import com.plcoding.cryptocurrencyappyt.domain.model.Joke
import com.plcoding.cryptocurrencyappyt.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetJokeUseCase @Inject constructor(
    private val repository: JokeRepository
) {
    operator fun invoke(): Flow<Resource<Joke>> = flow {
        try {
            emit(Resource.Loading<Joke>())
            val joke = repository.getJoke().toJoke()
            emit(Resource.Success<Joke>(joke))
        } catch (e: HttpException) {
            emit(Resource.Error<Joke>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error<Joke>("Check internet connection!"))
        }
    }
}