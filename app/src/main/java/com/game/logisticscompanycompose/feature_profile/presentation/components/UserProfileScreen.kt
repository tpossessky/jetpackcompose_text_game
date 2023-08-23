package com.game.logisticscompanycompose.feature_profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UserProfileScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        UserProfileCard()
        CardGrid()
    }
}