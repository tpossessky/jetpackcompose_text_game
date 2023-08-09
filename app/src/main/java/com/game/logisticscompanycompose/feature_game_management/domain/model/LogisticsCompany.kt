package com.game.logisticscompanycompose.feature_game_management.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LogisticsCompany(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val companyName : String,
    val userName : String,
    val cash : String,
    val xp : Int = 0,
    val level : Int = 0,
    val dateCreated: Long = System.currentTimeMillis()
)

class InvalidCompanyException(message: String) : Exception(message)