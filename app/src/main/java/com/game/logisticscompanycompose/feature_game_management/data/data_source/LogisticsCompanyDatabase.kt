package com.game.logisticscompanycompose.feature_game_management.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.game.logisticscompanycompose.feature_game_management.di.GameManagementModule
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider


@Database(
    entities = [LogisticsCompany::class],
    version = 1
)
abstract class LogisticsCompanyDatabase : RoomDatabase(){

    abstract val logCompDao : LogisticsCompanyDao

    companion object {
        const val DATABASE_NAME = "logistics_comp_db"
    }


    class Callback @Inject constructor(
        private val database: Provider<LogisticsCompanyDatabase>,
        @GameManagementModule.ApplicationScope private val applicationScope: CoroutineScope
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