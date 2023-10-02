package com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade
import kotlinx.coroutines.flow.Flow

@Dao
interface UpgradeDao {

    @Update
    suspend fun update(upgrade: Upgrade)


    @Query("SELECT * FROM Upgrade WHERE companyId = :companyId")
    suspend fun getAllUpgradesByCompanyId(companyId: Int) : Flow<List<Upgrade>>

}