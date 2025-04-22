package com.ahmetberkekaya.harrypotterapp

import CharacterScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.ahmetberkekaya.harrypotterapp.navigation.AppNavGraph
import com.ahmetberkekaya.harrypotterapp.ui.theme.HarryPotterAppTheme
import com.ahmetberkekekaya.harrypotterapp.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarryPotterAppTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController, viewModel = characterViewModel)
            }
        }

    }
}
