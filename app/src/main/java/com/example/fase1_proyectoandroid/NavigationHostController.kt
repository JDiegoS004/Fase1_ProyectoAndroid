package com.example.fase1_proyectoandroid

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType

import com.example.fase1_proyectoandroid.screens.LoginScreen
import com.example.fase1_proyectoandroid.screens.HomeScreen
import com.example.fase1_proyectoandroid.screens.DetailScreen

@Composable
fun NavigationHostController(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }

        // Recibe ID, título e imagen
        composable(
            route = "detail/{movieId}/{movieTitle}/{movieImage}",
            arguments = listOf(
                navArgument("movieId") { type = NavType.IntType },
                navArgument("movieTitle") { type = NavType.StringType },
                navArgument("movieImage") { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("movieId") ?: 0
            val title = backStackEntry.arguments?.getString("movieTitle") ?: ""
            val image = backStackEntry.arguments?.getInt("movieImage") ?: 0

            DetailScreen(
                navController = navController,
                movieId = id,
                movieTitle = title,
                movieImage = image
            )
        }
    }
}
