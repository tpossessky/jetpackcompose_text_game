package com.game.logisticscompanycompose.feature_vehicles.domain.use_case

import com.game.logisticscompanycompose.feature_vehicles.data.repository.VehicleRepository
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllVehiclesByCompanyId(
    private val repository: VehicleRepository
) {

    operator fun invoke(id: Int) : Flow<List<Vehicle>> {
        return repository.getAllVehiclesByCompanyId(id).map { vehicles ->
            vehicles.sortedBy { it.vehicleType }
        }
    }

}