package com.game.logisticscompanycompose.main.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.game.logisticscompanycompose.main.presentation.navigation.BottomNavigationItem

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    bottomNavItems: List<BottomNavigationItem>,
    navController : NavHostController,
    backStackEntry: State<NavBackStackEntry?>
) {
    BottomAppBar(
        modifier = modifier
            .height(60.dp),
        containerColor= Color.Black
    ) {
        bottomNavItems.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                //TODO: move to ViewModel
                onClick = { navController.navigate(item.route) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.route) },
                alwaysShowLabel = false,
                //TODO: COLOR
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor =  Color.Black,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.LightGray,
                )
            )
        }
    }

}


