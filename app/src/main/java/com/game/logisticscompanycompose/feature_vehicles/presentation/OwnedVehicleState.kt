package com.game.logisticscompanycompose.feature_vehicles.presentation

import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle

data class OwnedVehicleState(
    val vehicles : List<Vehicle> = emptyList(),
)