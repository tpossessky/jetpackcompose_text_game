package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.staff

import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.StaffMemberRepository

class GetAllStaff (
    private val repository: StaffMemberRepository
){


    suspend operator fun invoke(companyId : Int){
        repository.getAllStaffMembersByCompanyID(companyID = companyId)
    }
}