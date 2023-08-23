package com.game.logisticscompanycompose.feature_game_management.domain.repository

import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import kotlinx.coroutines.flow.Flow

interface LogisticsCompanyRepositoryInterface {

    fun getCompanies() : Flow<List<LogisticsCompany>>

    suspend fun getCompanyById(id: Int) : LogisticsCompany?

    suspend fun insertCompany(company : LogisticsCompany) : Long

    suspend fun deleteCompanyByID(id: Int)

    suspend fun updateCompany(company: LogisticsCompany)

}