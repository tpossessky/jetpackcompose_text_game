package com.game.logisticscompanycompose.feature_vehicles.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.game.logisticscompanycompose.feature_game_management.di.GameManagementModule
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [Vehicle::class],
    version = 1
)
abstract class VehicleDatabase : RoomDatabase() {

    abstract val vehicleDao : VehicleDao

    companion object {
        const val DATABASE_NAME = "vehicle_db"
    }

    class Callback @Inject constructor(
        private val database: Provider<VehicleDatabase>,
        @GameManagementModule.ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()

}