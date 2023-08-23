package com.game.logisticscompanycompose.feature_vehicles.domain.use_case

import com.game.logisticscompanycompose.feature_vehicles.data.repository.VehicleRepository
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle

class AddVehicle(
    private val repository: VehicleRepository
) {

    suspend operator fun invoke(vehicle: Vehicle): Int {
        //TODO: BUSINESS LOGIC TO ADDING VEHICLE IF ANY
        return repository.insert(vehicle).toInt()
    }
}