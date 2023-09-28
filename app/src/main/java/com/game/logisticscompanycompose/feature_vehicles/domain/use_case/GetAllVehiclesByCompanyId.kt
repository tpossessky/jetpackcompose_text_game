package com.game.logisticscompanycompose.feature_vehicles.domain.use_case

import com.game.logisticscompanycompose.feature_vehicles.data.repository.VehicleRepository
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllVehiclesByCompanyId(
    private val repository: VehicleRepository
) {

    operator fun invoke(id: Int, excludeCurrentlyUsed: Boolean = false): Flow<List<Vehicle>> {

        return if (excludeCurrentlyUsed) {
            repository.getAllVehiclesByCompanyId(id).map { vehicles ->
                vehicles.filter { !it.currentlyUsedInContract }.sortedBy { it.vehicleType }
            }
            //handles getting vehicles NOT currently used in contract
        } else {
            repository.getAllVehiclesByCompanyId(id).map { vehicles ->
                vehicles.sortedBy { it.vehicleType }
            }
        }
    }

}