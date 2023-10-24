package com.game.logisticscompanycompose.feature_game_management.data.repository

import com.game.logisticscompanycompose.feature_game_management.data.data_source.LogisticsCompanyDao
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_game_management.domain.repository.LogisticsCompanyRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LogisticsCompanyRepository @Inject constructor(
    private val dao: LogisticsCompanyDao
) : LogisticsCompanyRepositoryInterface {

    override fun getCompanies(): Flow<List<LogisticsCompany>> {
        return dao.getAllCompanies()
    }

    override suspend fun getCompanyById(id: Int): LogisticsCompany? {
        return dao.getCompany(id)
    }

    override fun observeCompanyByIdFlow(id: Int): Flow<LogisticsCompany?> {
        return dao.getCompanyFlow(id)
    }

    override suspend fun insertCompany(company: LogisticsCompany) : Long {
        return dao.insertCompany(company)
    }

    override suspend fun deleteCompanyByID(id: Int) {
        dao.deleteCompanyById(id)
    }

    override suspend fun updateCompany(company: LogisticsCompany) {
        dao.updateCompany(company)
    }

    override suspend fun updateCash(id: Int, amt: String){
        dao.updateCash(id= id, cash = amt)
    }
}