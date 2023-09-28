package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.repository

import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import kotlinx.coroutines.flow.Flow

interface StaffMemberRepositoryInterface {


    suspend fun addStaffMember(staffMember: StaffMember): Long
    suspend fun removeStaffMember(staffMember: StaffMember)
    suspend fun getAllStaffMembersByCompanyID(companyID: Int): Flow<List<StaffMember>>
}