package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.upgrades

import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.UpgradeRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade
import kotlinx.coroutines.flow.Flow

class GetUpgradesByCompanyId(
    private val repository: UpgradeRepository
) {

    operator fun invoke(id : Int): Flow<List<Upgrade>> {
        return repository.getAllUpgradesByCompanyId(id)
    }

}