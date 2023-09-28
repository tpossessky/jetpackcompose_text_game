package com.game.logisticscompanycompose.feature_vehicles.presentation

import com.game.logisticscompanycompose.feature_vehicles.domain.model.PurchasableVehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle

sealed class VehicleClickEvent {

    data class VehicleClickBuy(val vehicle : PurchasableVehicle) : VehicleClickEvent()
    data class VehicleClickSell(val vehicle: Vehicle) : VehicleClickEvent()
    data class VehicleClickUpgrade(val vehicle : Vehicle) : VehicleClickEvent()

}