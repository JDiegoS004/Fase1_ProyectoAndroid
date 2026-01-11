package com.example.fase1_proyectoandroid.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {

    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Bienvenido", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black)
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Campo de texto para ingresar el usuario
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Usuario") }
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Campo de texto para ingresar la contraseña
            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Contraseña") }
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            //Boton que, una vez introducidos el usuario y la contraseña, te lleva a la pantalla Home
            //Por el momento no hay ningun control sobre lo que se introduce
            Button(
                onClick = { navController.navigate("home") }
            ) {
                Text("Entrar")
            }
        }
    }
}
