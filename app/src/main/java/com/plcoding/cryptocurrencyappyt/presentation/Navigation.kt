package com.plcoding.cryptocurrencyappyt.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController




@Composable
fun HomeScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Center
    ) {
        Row (modifier = Modifier.align(Center)){
            Button(onClick = {
                    navController.navigate(Screen.ListJokeScreen.route)
                },
            ) {
                Text(text = "List Jokes")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                navController.navigate(Screen.RandomJokeScreen.route)
            },
            ) {
                Text(text = "Random Joke")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                navController.navigate(Screen.TextJokeScreen.route)
            },
            ) {
                Text(text = "Text Joke")
            }
        }
        Text(modifier = Modifier.align(TopCenter), text = "home screen")
        Spacer(modifier = Modifier.height(8.dp))

    }
}


sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object ListJokeScreen: Screen("list_joke_screen")
    object RandomJokeScreen: Screen("random_joke_screen")
    object TextJokeScreen: Screen("text_joke_screen")
}