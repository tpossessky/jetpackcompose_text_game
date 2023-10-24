package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.upgrades

import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.UpgradeRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade

class UpdateUpgrade(
    private val repository: UpgradeRepository
) {
    suspend operator fun invoke(upgrade : Upgrade){
        repository.updateUpgrade(upgrade)
    }

}