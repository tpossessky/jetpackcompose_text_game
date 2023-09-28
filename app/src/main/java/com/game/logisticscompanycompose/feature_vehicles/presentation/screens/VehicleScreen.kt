package com.game.logisticscompanycompose.feature_vehicles.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_vehicles.presentation.components.OwnedVehiclesList
import com.game.logisticscompanycompose.feature_vehicles.presentation.components.PurchasableVehicleList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VehicleScreen(
    modifier: Modifier = Modifier,
    company: LogisticsCompany
) {

    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Buy Vehicle", "My Vehicles")
    Column(modifier = modifier) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed {index, title ->
                Tab(selected = tabIndex == index, onClick = { tabIndex = index }) {
                    Text(text = title)
                }

            }
        }

        when(tabIndex) {
            0 -> PurchasableVehicleList(company = company)
            1 -> OwnedVehiclesList()
        }
    }






}


//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun VehicleScreen(
//    modifier: Modifier = Modifier,
////    viewModel: VehicleScreenViewModel = hiltViewModel(),
//    company: LogisticsCompany
//) {
//    val companyID = company.id
//
//    val navController = rememberNavController()
//    Scaffold(
//        modifier = modifier,
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                navController.navigate("${VehicleNavigationItem.MyVehiclesScreen.route}/$companyID")
//            }, shape = CircleShape) {
//            }
//        }
//    ) {
//        NavHost(
//            navController = navController,
//            startDestination = VehicleNavigationItem.PurchaseVehicleScreen.route,
//
//            ){
//            composable(VehicleNavigationItem.PurchaseVehicleScreen.route) {
//                PurchasableVehicleList(
//                    company = company
//                )
//            }
//            composable(
//                route = "${VehicleNavigationItem.MyVehiclesScreen.route}/{companyID}",
//                arguments = listOf(
//                    navArgument("companyID") { type = NavType.IntType }
//                )
//            ) {
//                OwnedVehiclesList()
//            }
//        }
//    }
//}


