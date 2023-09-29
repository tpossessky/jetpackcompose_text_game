package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case

import com.game.logisticscompanycompose.common.user.GlobalCompany
import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository.StaffMemberRepository
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.singleOrNull

class HireStaff(
    private val repository: StaffMemberRepository
) {
    suspend operator fun invoke(newStaff: StaffMember) {
        val companyId = GlobalCompany.getCurrentCompany().first()!!.id

        val currentStaffFlow = repository.getStaffMemberByJobCodeAndCompanyID(
            companyID = companyId, jobCode = newStaff.jobCode
        )

        val currentStaff = currentStaffFlow.singleOrNull()

        if (currentStaff != null) {
            // Handle the case when there is existing staff with the same job code
            // For example, you might want to update or notify about it.
        } else {
            // Handle the case when there is no existing staff with the same job code
            // You can proceed with hiring the new staff.
        }


    }
}