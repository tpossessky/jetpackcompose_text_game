package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.staff

import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.StaffMemberRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import kotlinx.coroutines.flow.Flow

class GetAllStaff (
    private val repository: StaffMemberRepository
){


    operator fun invoke(companyId : Int): Flow<List<StaffMember>> {
        return repository.getAllStaffMembersByCompanyID(companyID = companyId)
    }
}