package com.game.logisticscompanycompose.feature_vehicles.di

import android.app.Application
import androidx.room.Room
import com.game.logisticscompanycompose.feature_vehicles.data.data_source.VehicleDao
import com.game.logisticscompanycompose.feature_vehicles.data.data_source.VehicleDatabase
import com.game.logisticscompanycompose.feature_vehicles.data.repository.VehicleRepository
import com.game.logisticscompanycompose.feature_vehicles.domain.model.PurchasableVehiclesCollection
import com.game.logisticscompanycompose.feature_vehicles.domain.repository.VehicleRepositoryInterface
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.AddVehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.GetAllVehiclesByCompanyId
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.SellVehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.UpdateVehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.VehicleUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VehicleModule {

    @Provides
    @Singleton
    fun provideVehicleDatabase(app: Application,
                               callback: VehicleDatabase.Callback): VehicleDatabase {
        return Room.databaseBuilder(
            app,
            VehicleDatabase::class.java,
            VehicleDatabase.DATABASE_NAME
        ).addCallback(callback).build()
    }


    @Provides
    @Singleton
    fun provideVehicleDao(database: VehicleDatabase): VehicleDao {
        return database.vehicleDao
    }


    @Provides
    @Singleton
    fun provideVehicleRepository(db: VehicleDatabase)
            : VehicleRepositoryInterface {
        return VehicleRepository(db.vehicleDao)
    }


    @Provides
    @Singleton
    fun provideVehicleUseCase(
        repository: VehicleRepository) : VehicleUseCases {

        return VehicleUseCases(
            addVehicle = AddVehicle(repository),
            sellVehicle = SellVehicle(repository),
            getAllVehiclesByCompanyId = GetAllVehiclesByCompanyId(repository),
            updateVehicle = UpdateVehicle(repository)
        )
    }


    @Provides
    @Singleton
    fun providePurchasableVehiclesCollection() : PurchasableVehiclesCollection {
        return PurchasableVehiclesCollection
    }


}