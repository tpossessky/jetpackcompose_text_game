package com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation

import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade

sealed class UpgradeAndStaffClickEvent {

    data class UpgradeClickBuy(val upgrade : Upgrade) : UpgradeAndStaffClickEvent()
    data class StaffClickHire(val staffMember: StaffMember) : UpgradeAndStaffClickEvent()
    data class StaffClickFire(val staffMember: StaffMember) : UpgradeAndStaffClickEvent()

}
