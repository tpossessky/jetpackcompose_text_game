package com.game.logisticscompanycompose.feature_game_management.presentation

import androidx.compose.ui.graphics.Color
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany

data class SaveGameState(
    val games : List<LogisticsCompany> = emptyList(),
    val colors : List<Color> = emptyList()
)