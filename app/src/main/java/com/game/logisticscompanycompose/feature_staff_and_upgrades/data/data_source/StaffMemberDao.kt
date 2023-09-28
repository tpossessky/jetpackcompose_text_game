package com.game.logisticscompanycompose.feature_staff_and_upgrades.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import kotlinx.coroutines.flow.Flow

@Dao
interface StaffMemberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStaffMember(staffMember: StaffMember) : Long

    @Delete
    suspend fun removeStaffMember(staffMember: StaffMember)

    @Query("SELECT * FROM StaffMember WHERE companyId = :companyId")
    fun getAllStaffByCompanyID(companyId: Int) : Flow<List<StaffMember>>

}