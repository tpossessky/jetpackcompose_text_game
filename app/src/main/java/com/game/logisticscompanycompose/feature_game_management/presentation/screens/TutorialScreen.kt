package com.game.logisticscompanycompose.feature_game_management.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TutorialScreen(
    modifier: Modifier = Modifier
) {

    Text(
        modifier = modifier.padding(16.dp),
        text = "Tutorial Screen",
        style= TextStyle(
            fontWeight = FontWeight.Black
        )
    )
    
}