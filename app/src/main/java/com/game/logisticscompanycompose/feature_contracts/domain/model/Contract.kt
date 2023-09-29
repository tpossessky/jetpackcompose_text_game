package com.game.logisticscompanycompose.feature_contracts.domain.model

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
class Contract(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val issuingCompany: String,
    val lengthInWeeks: Int,
    val weeksRemaining: Int,
    val payPerWeek: Int,
    val packagesPerWeek: Int,
    val companyId: Int,
    var vehicleId: Int
)
