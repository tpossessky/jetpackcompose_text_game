package com.game.logisticscompanycompose.feature_contracts.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contract (
    @PrimaryKey(autoGenerate = true) val id : Int = 1,
    val issuingCompany : String,
    val lengthInWeeks : Int,
    val weeksRemaining : Int,
    val payPerWeek : Int,
    val packagesPerWeek: Int,
    val companyId : Int,
)