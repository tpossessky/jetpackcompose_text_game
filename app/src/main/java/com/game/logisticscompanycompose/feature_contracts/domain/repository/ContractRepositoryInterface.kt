package com.game.logisticscompanycompose.feature_contracts.domain.repository

import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import kotlinx.coroutines.flow.Flow

interface ContractRepositoryInterface {

    fun getAllContractsByCompanyId(id: Int): Flow<List<Contract>>

    suspend fun deleteContract(contract: Contract)

    suspend fun deleteContractById(id: Int)

    suspend fun insert(contract: Contract) : Long

    suspend fun updateContract(contract: Contract)
}