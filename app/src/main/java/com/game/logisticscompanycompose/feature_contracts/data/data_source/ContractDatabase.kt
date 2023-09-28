package com.game.logisticscompanycompose.feature_contracts.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_game_management.di.GameManagementModule
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [Contract::class],
    version = 1
)
@TypeConverters(IntListConverter::class)
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

class IntListConverter {

    @TypeConverter
    fun fromList(list: List<Int>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun toList(value: String?): List<Int>? {
        return value?.split(",")?.mapNotNull { it.toIntOrNull() }
    }
}