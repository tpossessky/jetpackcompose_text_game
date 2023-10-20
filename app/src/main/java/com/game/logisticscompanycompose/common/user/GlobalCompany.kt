package com.game.logisticscompanycompose.common.user

import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

object GlobalCompany {
    private lateinit var company: Flow<LogisticsCompany?>

    fun setCurrentCompany(comp: Flow<LogisticsCompany?>) {
        company = comp
    }

    fun getCurrentCompany(): Flow<LogisticsCompany?> {
        return company
    }

    suspend fun getCurrentCompanyID(): Int {
        return company.first()?.id ?: -1
    }

}

