package com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation

import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade

data class UpgradeState(
    val upgrades : List<Upgrade> = emptyList()
)
