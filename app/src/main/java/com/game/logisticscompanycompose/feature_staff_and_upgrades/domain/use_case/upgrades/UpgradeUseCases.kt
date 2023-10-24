package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.upgrades

data class UpgradeUseCases (
    val upgradeInitUseCase : UpgradeInitUseCase,
    val getAllUpgradesByCompanyId: GetUpgradesByCompanyId,
    val updateUpgrade: UpdateUpgrade
)