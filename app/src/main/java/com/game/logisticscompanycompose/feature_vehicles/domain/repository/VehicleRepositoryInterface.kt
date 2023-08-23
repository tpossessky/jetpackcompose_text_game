package com.game.logisticscompanycompose.feature_vehicles.domain.repository

import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import kotlinx.coroutines.flow.Flow

interface VehicleRepositoryInterface {

    fun getAllVehiclesByCompanyId(id: Int): Flow<List<Vehicle>>

//    suspend fun getVehicleById(id: Int) : Vehicle?

    suspend fun deleteVehicle(vehicle: Vehicle)

    suspend fun deleteVehicleById(id: Int)

    suspend fun insert(vehicle: Vehicle) : Long

    suspend fun updateVehicle(vehicle: Vehicle)
}