package com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDatabase
import com.game.logisticscompanycompose.feature_game_management.di.GameManagementModule
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [StaffMember::class],
    version = 1
)
abstract class StaffMemberDatabase : RoomDatabase(){

    abstract val staffMemberDao : StaffMemberDao

    companion object {
        const val DATABASE_NAME = "staff_member_db"
    }

    class Callback @Inject constructor(
        private val database: Provider<LogisticsCompanyDatabase>,
        @GameManagementModule.ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()

}
