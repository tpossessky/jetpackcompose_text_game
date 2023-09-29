package com.game.logisticscompanycompose.common.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.game.logisticscompanycompose.common.di.AppModule
import com.game.logisticscompanycompose.feature_contracts.data.data_source.ContractDao
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDao
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source.StaffMemberDao
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import com.game.logisticscompanycompose.feature_vehicles.data.data_source.VehicleDao
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider


@Database(
    entities = [
        LogisticsCompany::class,
        Vehicle::class,
        Contract::class,
        StaffMember::class
    ],
    version = 1
)
abstract class LogisticsCompanyDatabase : RoomDatabase(){

    abstract val logCompDao : LogisticsCompanyDao
    abstract val vehicleDao : VehicleDao
    abstract val contractDao : ContractDao
    abstract val staffMemberDao : StaffMemberDao

    companion object {
        const val DATABASE_NAME = "logistics_comp_db"
    }


    class Callback @Inject constructor(
        private val database: Provider<LogisticsCompanyDatabase>,
        @AppModule.ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//            //db operations
//            //gets database by lazy
//            val dao = database.get().logCompDao
//
//            applicationScope.launch {
//                dao.insertCompany(
//                    LogisticsCompany(
//                        companyName = "Federated Shipping",
//                        userName = "John Smith",
//                        cash = "15000",
//                        xp = 150,
//                        level = 3
//                    )
//                )
//
//                dao.insertCompany(
//                    LogisticsCompany(
//                        companyName = "United Shipping",
//                        userName = "Able Smith",
//                        cash = "15000",
//                        xp = 150,
//                        level = 3
//                    )
//                )
//                dao.insertCompany(
//                    LogisticsCompany(
//                        companyName = "Postal Shipping",
//                        userName = "Butter Smith",
//                        cash = "15000",
//                        xp = 150,
//                        level = 3
//                    )
//                )
//                dao.insertCompany(
//                    LogisticsCompany(
//                        companyName = "White Van",
//                        userName = "Creep",
//                        cash = "15000",
//                        xp = 150,
//                        level = 3
//                    )
//                )
//                dao.insertCompany(
//                    LogisticsCompany(
//                        companyName = "Ship",
//                        userName = "Shipper",
//                        cash = "15000",
//                        xp = 150,
//                        level = 3
//                    )
//                )
//                dao.insertCompany(
//                    LogisticsCompany(
//                        companyName = "UPS",
//                        userName = "Frederick Highsmith",
//                        cash = "15000",
//                        xp = 150,
//                        level = 3
//                    )
//                )
//                dao.insertCompany(
//                    LogisticsCompany(
//                        companyName = "DHL",
//                        userName = "Wehrner von Heidel",
//                        cash = "15000",
//                        xp = 150,
//                        level = 3
//                    )
//                )
//                dao.insertCompany(
//                    LogisticsCompany(
//                        companyName = "China Air",
//                        userName = "Chinaman",
//                        cash = "15000",
//                        xp = 150,
//                        level = 3
//                    )
//                )
//            }
//        }
    }
}