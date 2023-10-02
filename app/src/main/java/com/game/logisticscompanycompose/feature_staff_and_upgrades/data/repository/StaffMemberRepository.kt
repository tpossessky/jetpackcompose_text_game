package com.game.logisticscompanycompose.feature_staff_and_upgrades.data.repository

import com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source.StaffMemberDao
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.repository.StaffMemberRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StaffMemberRepository @Inject constructor(
    private val dao: StaffMemberDao
) : StaffMemberRepositoryInterface {


    override suspend fun addStaffMember(staffMember: StaffMember): Long {
        return dao.addStaffMember(staffMember = staffMember)
    }


    override suspend fun removeStaffMember(staffMember: StaffMember) {
        dao.removeStaffMember(staffMember = staffMember)
    }


    override suspend fun getAllStaffMembersByCompanyID(companyID: Int): Flow<List<StaffMember>> {
        return dao.getAllStaffByCompanyID(companyId = companyID)
    }


    override suspend fun getStaffMemberByJobCodeAndCompanyID(
        companyID: Int, jobCode: Int
    ): Flow<StaffMember> {
        return dao.getStaffMemberByJobCodeAndCompanyID(companyId = companyID, jobCode = jobCode)
    }


}