package com.plcoding.cryptocurrencyappyt.presentation.listjokes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.plcoding.cryptocurrencyappyt.domain.model.Joke


/**
 * need to research lazy column.
 * this item will house the individual jokes
 * The final display will be a list of ~20 jokes
 * then when user reaches the bottom of list call 20 more
 */

@Composable
fun ListJokesItem (
    joke: Joke,
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = joke.value,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}