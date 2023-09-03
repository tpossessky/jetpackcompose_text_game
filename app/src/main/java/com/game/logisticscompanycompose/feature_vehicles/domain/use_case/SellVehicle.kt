package com.game.logisticscompanycompose.feature_vehicles.domain.use_case

import com.game.logisticscompanycompose.feature_vehicles.data.repository.VehicleRepository

class SellVehicle (
    val repository: VehicleRepository
) {

    suspend operator fun invoke(id : Int) {
        repository.deleteVehicleById(id)
    }

}