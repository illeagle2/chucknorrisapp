package com.plcoding.cryptocurrencyappyt.domain.use_case.get_jokes

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toJoke
import com.plcoding.cryptocurrencyappyt.domain.model.Joke
import com.plcoding.cryptocurrencyappyt.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetJokesUseCase @Inject constructor(
    private val repository: JokeRepository
) {
    operator fun invoke(): Flow<Resource<List<Joke>>> = flow {
        try {
            emit(Resource.Loading<List<Joke>>())
            //gets one joke
            //val joke = repository.getJokes().toJoke()
            //gets 20 jokes and displays a list
            val jokes = mutableListOf<Joke>()
            for (i in 1..20){
                jokes.add(repository.getJokes().toJoke())
            }
            emit(Resource.Success<List<Joke>>(jokes))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Joke>>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Joke>>("Check internet connection!"))
        }
    }
}