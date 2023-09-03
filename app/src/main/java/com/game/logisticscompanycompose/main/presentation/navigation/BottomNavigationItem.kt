package com.game.logisticscompanycompose.main.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.game.logisticscompanycompose.R

sealed class BottomNavigationItem (
    val route: String, @StringRes val resourceId: Int, val icon: ImageVector
) {
    object Home :
        BottomNavigationItem("Home", R.string.home_route, Icons.Filled.Build)
    object Profile :
        BottomNavigationItem("Profile", R.string.profile_route, Icons.Filled.DateRange)
    object Vehicles :
        BottomNavigationItem("Vehicles", R.string.vehicles_route, Icons.Filled.ThumbUp)
    object Facilities :
        BottomNavigationItem("Facilities", R.string.facilities_route, Icons.Filled.Settings)
    object Test :
        BottomNavigationItem("Test", R.string.test_route, Icons.Filled.Email)

    companion object {
        fun getNavigationItems() = listOf(
            Home,
            Profile,
            Vehicles,
            Facilities,
            Test
        )
    }

}

