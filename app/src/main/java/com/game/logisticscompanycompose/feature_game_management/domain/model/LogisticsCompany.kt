package com.game.logisticscompanycompose.feature_game_management.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LogisticsCompany (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val companyName : String,
    val userName : String,
    var cash : String,
    val xp : Int = 0,
    val level : Int = 1,
    val dateCreated: Long = System.currentTimeMillis()
)

open class InvalidCompanyException(message: String) : Exception(message)

class InvalidCompanyNameException(message: String) : InvalidCompanyException(message)
class InvalidOwnerNameException(message: String) : InvalidCompanyException(message)