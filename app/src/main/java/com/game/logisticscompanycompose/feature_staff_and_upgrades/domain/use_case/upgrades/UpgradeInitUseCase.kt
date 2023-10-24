package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.upgrades

import android.util.Log
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.UpgradeRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade
import com.game.logisticscompanycompose.utils.GameConstants

class UpgradeInitUseCase (
    private val upgradeRepo: UpgradeRepository
) {

    suspend operator fun invoke(companyID: Int) {
        val upgradeList : MutableList<Upgrade> = mutableListOf()
        //TODO: Extract list to constant
        for(upgrade in GameConstants.UPGRADE.values().toList()){
            Log.wtf("GA", "INSERT")
            upgradeRepo.insert(
                Upgrade(
                    companyId = companyID,
                    active = false,
                    upgradeName = upgrade.upgradeName,
                    effect = upgrade.code.code,
                    percentBoost = upgrade.percentIncrease,
                    levelReq = upgrade.levelReq,
                    purchasePrice = upgrade.purchasePrice
                )
            )
        }

    }
}