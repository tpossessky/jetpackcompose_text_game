package com.game.logisticscompanycompose.feature_contracts.domain.use_case

import com.game.logisticscompanycompose.feature_contracts.data.repository.ContractRepository
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetContractsByCompanyId(
    private val repository: ContractRepository
) {

    operator fun invoke(id: Int) : Flow<List<Contract>> {
        val x = repository.getAllContractsByCompanyId(id).map { contract ->
            contract.sortedBy { it.weeksRemaining }
        }


        return x
    }

}