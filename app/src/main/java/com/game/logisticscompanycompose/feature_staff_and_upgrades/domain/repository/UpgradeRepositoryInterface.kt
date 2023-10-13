package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.repository

import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade
import kotlinx.coroutines.flow.Flow

interface UpgradeRepositoryInterface {
    suspend fun updateUpgrade(upgrade: Upgrade)
    fun getAllUpgradesByCompanyId(companyId: Int): Flow<List<Upgrade>>
    suspend fun insert(upgrade: Upgrade)
}