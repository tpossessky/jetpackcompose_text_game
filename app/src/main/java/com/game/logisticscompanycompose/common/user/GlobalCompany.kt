package com.game.logisticscompanycompose.common.user

import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import kotlinx.coroutines.flow.Flow

object GlobalCompany {
    private lateinit var company: Flow<LogisticsCompany?>

    fun setCurrentCompany(comp: Flow<LogisticsCompany?>) {
        company = comp
    }

    fun getCurrentCompany(): Flow<LogisticsCompany?> {
        return company
    }
}

