package com.game.logisticscompanycompose.feature_game_management.data.repository

import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDao
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_game_management.domain.repository.LogisticsCompanyRepositoryInterface
import kotlinx.coroutines.flow.Flow


class LogisticsCompanyRepository(
    private val dao : LogisticsCompanyDao
) : LogisticsCompanyRepositoryInterface{

    override fun getCompanies(): Flow<List<LogisticsCompany>> {
        return dao.getAllCompanies()
    }

    override suspend fun getCompanyById(id: Int): LogisticsCompany? {
        return dao.getCompany(id)
    }

    override suspend fun insertCompany(company: LogisticsCompany) {
        dao.insertCompany(company)
    }

    override suspend fun deleteCompany(company: LogisticsCompany) {
        dao.deleteCompany(company)
    }

    override suspend fun updateCompany(company: LogisticsCompany) {
        dao.updateCompany(company)
    }
}