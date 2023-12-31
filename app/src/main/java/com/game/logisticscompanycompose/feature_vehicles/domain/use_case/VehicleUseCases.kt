package com.game.logisticscompanycompose.feature_vehicles.domain.use_case

data class VehicleUseCases (
    val addVehicle : AddVehicle,
    val sellVehicle: SellVehicle,
    val getAllVehiclesByCompanyId: GetAllVehiclesByCompanyId,
    val updateVehicle : UpdateVehicle
)