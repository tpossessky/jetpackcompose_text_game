package com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade
import kotlinx.coroutines.flow.Flow

@Dao
interface UpgradeDao {

    @Insert
    suspend fun insert(upgrade: Upgrade)

    @Insert
    @Transaction
    suspend fun insertAll(upgrades: List<Upgrade>)

    @Update
    suspend fun update(upgrade: Upgrade)


    @Query("SELECT * FROM Upgrade WHERE companyId = :companyId")
    fun getAllUpgradesByCompanyId(companyId: Int) : Flow<List<Upgrade>>

}