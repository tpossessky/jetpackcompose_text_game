package com.game.logisticscompanycompose.feature_vehicles.data.repository

import com.game.logisticscompanycompose.feature_vehicles.data.data_source.VehicleDao
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.repository.VehicleRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VehicleRepository @Inject constructor(
    private val vehicleDao: VehicleDao
) : VehicleRepositoryInterface {

    override fun getAllVehiclesByCompanyId(id: Int): Flow<List<Vehicle>> {
        return vehicleDao.getAllVehiclesByCompanyID(id)
    }

//    override suspend fun getVehicleById(id: Int): Vehicle? {
//        return vehicleDao.
//    }

    override suspend fun deleteVehicle(vehicle: Vehicle) {
        vehicleDao.delete(vehicle)
    }

    override suspend fun deleteVehicleById(id: Int) {
        vehicleDao.deleteById(id)
    }

    override suspend fun insert(vehicle: Vehicle): Long {
        return vehicleDao.insertVehicle(vehicle)
    }

    override suspend fun updateVehicle(vehicle: Vehicle) {
        vehicleDao.updateVehicle(vehicle)
    }


}
