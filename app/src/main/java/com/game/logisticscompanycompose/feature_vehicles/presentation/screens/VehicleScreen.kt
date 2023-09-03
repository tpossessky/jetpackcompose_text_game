package com.game.logisticscompanycompose.feature_vehicles.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_vehicles.presentation.components.OwnedVehiclesList
import com.game.logisticscompanycompose.feature_vehicles.presentation.components.PurchasableVehicleList
import com.game.logisticscompanycompose.feature_vehicles.presentation.navigation.VehicleNavigationItem
import com.game.logisticscompanycompose.feature_vehicles.presentation.view_models.VehicleScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VehicleScreen(
    modifier: Modifier = Modifier,
    viewModel: VehicleScreenViewModel = hiltViewModel(),
    company: LogisticsCompany
) {

    val companyID = company.id

    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("${VehicleNavigationItem.MyVehiclesScreen.route}/$companyID")
            }, shape = CircleShape) {
            }
        } 
    ) {
        NavHost(
            navController = navController,
            startDestination = VehicleNavigationItem.PurchaseVehicleScreen.route,
            
        ){
            composable(VehicleNavigationItem.PurchaseVehicleScreen.route) {
                PurchasableVehicleList(
                    company = company
                )
            }
            composable(
                route = "${VehicleNavigationItem.MyVehiclesScreen.route}/{companyID}",
                arguments = listOf(
                    navArgument("companyID") { type = NavType.IntType }
                )
            ) {
                OwnedVehiclesList()
            }
        }
    }
}



