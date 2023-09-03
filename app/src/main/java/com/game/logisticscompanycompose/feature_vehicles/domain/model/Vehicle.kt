package com.game.logisticscompanycompose.feature_vehicles.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
open class Vehicle (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    open val vehicleType : String,
    var upgradeTotal : Int = 0,
    val companyId: Int = -1,
    val currentlyUsedInContract: Boolean = false,
    )



