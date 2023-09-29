package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany

@Entity(foreignKeys = [
    ForeignKey(
        entity = LogisticsCompany::class,
        parentColumns = ["id"],
        childColumns = ["companyId"],
        onDelete = ForeignKey.CASCADE
    )
])
data class StaffMember (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val companyID : Int = -1,
    val staffMemberName : String,
    val percentBoost : Int,
    val weeklySalary : Int,
    val jobCode : Int
)

