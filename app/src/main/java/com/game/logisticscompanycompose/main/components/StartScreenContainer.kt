package com.game.logisticscompanycompose.main.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.game.logisticscompanycompose.feature_game_management.presentation.screens.LoadGameScreen
import com.game.logisticscompanycompose.feature_game_management.presentation.screens.StartScreen
import com.game.logisticscompanycompose.feature_game_management.presentation.screens.TutorialScreen
import com.game.logisticscompanycompose.main.navigation.StartScreenNavigationItem

@Composable
fun StartScreenContainer(
    modifier: Modifier = Modifier,
    onLoadGame : (Int) -> Unit
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = StartScreenNavigationItem.StartScreen.route
    ) {
        composable(StartScreenNavigationItem.StartScreen.route) {
            StartScreen(navController = navController) {
                onLoadGame(it)
            }
        }
        composable(StartScreenNavigationItem.LoadGame.route) {
            LoadGameScreen(navController = navController){
                onLoadGame(it)
            }
        }
        composable(StartScreenNavigationItem.Tutorial.route) {
            TutorialScreen()
        }
    }
}
