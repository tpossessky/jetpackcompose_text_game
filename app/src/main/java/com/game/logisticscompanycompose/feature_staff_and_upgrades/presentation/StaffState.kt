package com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation

import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember

data class StaffState(
    val staff : List<StaffMember> = emptyList()
)
