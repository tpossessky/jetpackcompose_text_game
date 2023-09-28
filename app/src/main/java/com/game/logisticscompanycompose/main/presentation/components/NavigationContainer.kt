package com.game.logisticscompanycompose.main.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.game.logisticscompanycompose.feature_contracts.presentation.screens.ContractContainer
import com.game.logisticscompanycompose.feature_profile.presentation.components.UserProfileScreen
import com.game.logisticscompanycompose.feature_vehicles.presentation.screens.VehicleScreen
import com.game.logisticscompanycompose.main.presentation.navigation.BottomNavigationItem
import com.game.logisticscompanycompose.main.presentation.viewmodels.NavigationContainerViewModel
import com.game.logisticscompanycompose.utils.GenericUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationContainer(
    companyId: Int,
    viewModel : NavigationContainerViewModel = hiltViewModel()
) {

    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    val bottomNavItems = BottomNavigationItem.getNavigationItems()
    val coroutineScope = rememberCoroutineScope()

    val company by viewModel.companyData.collectAsState()
    viewModel.setCompanyIdAndObserve(companyId)

    if (company != null) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = company!!.companyName,
                                style = TextStyle(color = Color.White, fontWeight = FontWeight.Black)
                            )
                            Text(
                                text = GenericUtils.formatCash(company!!.cash),
                                style = TextStyle(color = Color.White, fontWeight = FontWeight.Black)
                            )
                            //TODO: UPDATE ANIMATED CASH COMPONENT
                            //AnimatedCashText(count = company!!.cash.toBigInteger())
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Blue
                    )
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    bottomNavItems = bottomNavItems,
                    navController = navController,
                    backStackEntry = backStackEntry
                )
            },
            //content for scaffold
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = BottomNavigationItem.Profile.route
            ) {
                composable(BottomNavigationItem.Home.route) {
                    Text(text = "Home Content", modifier = Modifier.padding(innerPadding))
                }
                composable(BottomNavigationItem.Profile.route) {
                    UserProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable(BottomNavigationItem.Facilities.route) {
                    Text(
                        text = "Facilities Content",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable(BottomNavigationItem.Vehicles.route) {
                    VehicleScreen(
                        company = company!!,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable(BottomNavigationItem.Test.route) {
                    ContractContainer(company = company!!,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    } else {
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
        }
    }
}