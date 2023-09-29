package com.game.logisticscompanycompose.feature_vehicles.domain.model

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
open class Vehicle (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    open val vehicleType : String,
    var upgradeTotal : Int = 0,
    val companyId: Int = -1,
    var currentlyUsedInContract: Boolean = false,
    )



