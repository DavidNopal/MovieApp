package com.example.learnnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(movieViewModel: MovieViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.screenA,
    ) {
        composable(Routes.screenA) {
            ScreenA(navController, movieViewModel)
        }
        composable(Routes.screenB + "/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toInt()?: 0
            ScreenB(navController, movieViewModel, movieId)
        }
        composable(Routes.screenC) {
            ScreenC(navController, movieViewModel)
        }
    }
}