package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StaffMember (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val companyID : Int = -1,
    val staffMemberName : String,
    val percentBoost : Int,
    val weeklySalary : Int,
    val jobCode : Int
)

