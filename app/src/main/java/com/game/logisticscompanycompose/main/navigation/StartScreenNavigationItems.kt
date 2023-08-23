package com.game.logisticscompanycompose.main.navigation

sealed class StartScreenNavigationItem (val route : String) {
    object StartScreen : StartScreenNavigationItem("start_screen_route")
    object NewGame : StartScreenNavigationItem("new_game_route")
    object LoadGame : StartScreenNavigationItem("load_game_route")
    object Tutorial : StartScreenNavigationItem("tutorial_route")
}