package com.game.logisticscompanycompose.feature_contracts.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_game_management.di.GameManagementModule
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [Contract::class],
    version = 1
)
abstract class ContractDatabase : RoomDatabase() {

    abstract val contractDao : ContractDao

    companion object {
        const val DATABASE_NAME = "contract_db"
    }

    class Callback @Inject constructor(
        private val database: Provider<ContractDatabase>,
        @GameManagementModule.ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()

}