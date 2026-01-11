package com.example.fase1_proyectoandroid.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.fase1_proyectoandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    // Lista de películas con ID, Nombre e Imagen
    val movies = listOf(
        Triple(1, "Frankenstein", R.drawable.frankenstein),
        Triple(2, "Wall-E", R.drawable.walle),
        Triple(3, "Titanic", R.drawable.titanic),
        Triple(4, "Cars", R.drawable.cars)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Tu Top de Películas") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red)
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            movies.forEach { movie ->

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController.navigate(
                                "detail/${movie.first}/${movie.second}/${movie.third}"
                            )
                        }
                ) {

                    Text(
                        text = "${movie.first} - ${movie.second}",
                        fontSize = 24.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = movie.third),
                        contentDescription = movie.second,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                }
            }
        }
    }
}