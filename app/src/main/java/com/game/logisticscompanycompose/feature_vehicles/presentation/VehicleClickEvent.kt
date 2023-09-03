package com.game.logisticscompanycompose.feature_vehicles.presentation

import com.game.logisticscompanycompose.feature_vehicles.domain.model.PurchasableVehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle

sealed class VehicleClickEvent {

    /*
    data class GameManagementClickCompany(val id : Int) : GameManagementClickEvent()
    data class GameManagementClickDelete(val id : Int) : GameManagementClickEvent()
    object ConfirmDelete : GameManagementClickEvent()

    object NavigateNewGame : GameManagementClickEvent()
    object NavigateTutorial : GameManagementClickEvent()
    object NavigateLoadGame : GameManagementClickEvent()
     */

    data class VehicleClickBuy(val vehicle : PurchasableVehicle) : VehicleClickEvent()
    data class VehicleClickSell(val vehicle: Vehicle) : VehicleClickEvent()
    data class VehicleClickUpgrade(val vehicle : Vehicle) : VehicleClickEvent()


}