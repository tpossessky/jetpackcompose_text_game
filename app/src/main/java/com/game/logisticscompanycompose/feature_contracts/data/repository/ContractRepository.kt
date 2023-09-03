package com.game.logisticscompanycompose.feature_contracts.data.repository

import com.game.logisticscompanycompose.feature_contracts.data.data_source.ContractDao
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_contracts.domain.repository.ContractRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContractRepository
@Inject constructor(private val contractDao: ContractDao):
    ContractRepositoryInterface {

    override fun getAllContractsByCompanyId(id: Int): Flow<List<Contract>> {
        return contractDao.getAllContractsByCompanyID(id)
    }

    override suspend fun deleteContract(contract: Contract) {
        contractDao.delete(contract)
    }

    override suspend fun deleteContractById(id: Int) {
        contractDao.deleteById(id)
    }

    override suspend fun insert(contract: Contract): Long {
        return contractDao.insertContract(contract)
    }

    override suspend fun updateContract(contract: Contract) {
        contractDao.updateContract(contract)
    }
}