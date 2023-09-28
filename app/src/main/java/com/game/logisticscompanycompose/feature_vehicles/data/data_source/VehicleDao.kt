package com.game.logisticscompanycompose.feature_vehicles.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {

    @Query("SELECT * FROM Vehicle WHERE companyId = :companyId")
    fun getAllVehiclesByCompanyID(companyId: Int) : Flow<List<Vehicle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicle(vehicle: Vehicle) : Long

    @Update
    suspend fun updateVehicle(vehicle: Vehicle)

    @Delete
    suspend fun delete(vehicle: Vehicle)

    @Query("DELETE FROM Vehicle WHERE id = :id")
    suspend fun deleteById(id: Int)




}