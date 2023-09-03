package com.game.logisticscompanycompose.feature_vehicles.domain.use_case

import com.game.logisticscompanycompose.feature_vehicles.data.repository.VehicleRepository
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle

class UpdateVehicle (
    val repository: VehicleRepository
) {

    suspend operator fun invoke(vehicle: Vehicle) {
        repository.updateVehicle(vehicle)
    }

}