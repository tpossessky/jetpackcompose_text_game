package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case

import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.StaffMemberRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember

class FireStaff (
    private val repository: StaffMemberRepository
){


    suspend operator fun invoke(staffMember: StaffMember){
        repository.removeStaffMember(staffMember = staffMember)
    }
}