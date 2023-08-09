package com.game.logisticscompanycompose.feature_game_management.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany


@Database(
    entities = [LogisticsCompany::class],
    version = 1
)
abstract class LogisticsCompanyDatabase : RoomDatabase(){

    abstract val logCompDao : LogisticsCompanyDao

    companion object {
        const val DATABASE_NAME = "logistics_comp_db"
    }

}