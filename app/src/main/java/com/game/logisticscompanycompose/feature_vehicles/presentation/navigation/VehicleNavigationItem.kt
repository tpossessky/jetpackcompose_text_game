package com.game.logisticscompanycompose.feature_vehicles.presentation.navigation

sealed class VehicleNavigationItem (val route : String){
    object PurchaseVehicleScreen : VehicleNavigationItem("purchase_vehicle_route")
    object MyVehiclesScreen : VehicleNavigationItem("my_vehicles_screen")
}
