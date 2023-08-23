package com.game.logisticscompanycompose.utils

sealed class Screen (val route : String){
    object SaveGameScreen : Screen("save_game_screen")
}