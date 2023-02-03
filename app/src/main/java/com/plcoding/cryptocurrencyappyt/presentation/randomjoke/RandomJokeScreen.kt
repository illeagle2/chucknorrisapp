package com.plcoding.cryptocurrencyappyt.presentation.randomjoke

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun RandomJokeScreen (
    viewModel: RandomJokeViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Random Joke Screen",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Text(
            text = state.joke?.value ?: "",
            modifier = Modifier.align(Alignment.Center)
        )
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}