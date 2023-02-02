package com.plcoding.cryptocurrencyappyt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cryptocurrencyappyt.presentation.listjokes.ListJokesScreen
import com.plcoding.cryptocurrencyappyt.presentation.randomjoke.RandomJokeScreen
import com.plcoding.cryptocurrencyappyt.presentation.textjoke.TextJokeScreen
import com.plcoding.cryptocurrencyappyt.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(
                            route = Screen.HomeScreen.route
                        ) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            route = Screen.RandomJokeScreen.route
                        ) {
                            RandomJokeScreen()
                        }
                        composable(
                            route = Screen.ListJokeScreen.route
                        ) {
                            ListJokesScreen()
                        }
                        composable(
                            route = Screen.TextJokeScreen.route
                        ) {
                            TextJokeScreen()
                        }
                    }
                }
            }
        }
    }
}