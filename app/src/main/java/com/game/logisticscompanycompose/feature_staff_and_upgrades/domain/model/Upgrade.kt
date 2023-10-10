package com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany


@Entity(foreignKeys = [
    ForeignKey(
        entity = LogisticsCompany::class,
        parentColumns = ["id"],
        childColumns = ["companyId"],
        onDelete = ForeignKey.CASCADE
    )
])
data class Upgrade (
    val companyId : Int = -1,
    val active : Boolean,
    val upgradeName : String,
    val effect : Int,
    val percentBoost : Double
)