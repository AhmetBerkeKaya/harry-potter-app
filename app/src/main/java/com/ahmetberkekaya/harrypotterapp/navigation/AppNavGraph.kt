package com.ahmetberkekaya.harrypotterapp.navigation

import CharacterDetailScreen
import CharacterScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ahmetberkekaya.harrypotterapp.ui.screens.MainMenuScreen
import com.ahmetberkekekaya.harrypotterapp.viewmodel.CharacterViewModel

@Composable
fun AppNavGraph(navController: NavHostController, viewModel: CharacterViewModel) {
    NavHost(navController = navController, startDestination = "mainMenu") {
        composable("mainMenu") {
            MainMenuScreen(navController)
        }
        composable("characterList") {
            CharacterScreen(viewModel, navController)
        }
        composable("characterDetail/{characterName}") { backStackEntry ->
            val characterName = backStackEntry.arguments?.getString("characterName")
            val characters = viewModel.characters.collectAsState().value // StateFlow kullanımı
            val character = characters.find { it.name == characterName }
            character?.let {
                CharacterDetailScreen(it, navController)
            }
        }
    }
}


