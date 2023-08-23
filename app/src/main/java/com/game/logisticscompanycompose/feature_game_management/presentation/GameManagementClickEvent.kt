package com.game.logisticscompanycompose.feature_game_management.presentation


sealed class GameManagementClickEvent {
    data class GameManagementClickCompany(val id : Int) : GameManagementClickEvent()
    data class GameManagementClickDelete(val id : Int) : GameManagementClickEvent()
    object ConfirmDelete : GameManagementClickEvent()

    object NavigateNewGame : GameManagementClickEvent()
    object NavigateTutorial : GameManagementClickEvent()
    object NavigateLoadGame : GameManagementClickEvent()
}