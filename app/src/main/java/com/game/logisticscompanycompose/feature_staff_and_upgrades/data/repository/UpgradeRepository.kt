package com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository

import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source.UpgradeDao
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.repository.UpgradeRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpgradeRepository @Inject constructor(
    private val upgradeDao: UpgradeDao
) : UpgradeRepositoryInterface {


    override suspend fun insert(upgrade: Upgrade){
        upgradeDao.insert(upgrade)
    }


    override suspend fun updateUpgrade(upgrade: Upgrade) {
        upgradeDao.update(upgrade)
    }


    override fun getAllUpgradesByCompanyId(companyId: Int) : Flow<List<Upgrade>> {
        return upgradeDao.getAllUpgradesByCompanyId(companyId = companyId)
    }


}