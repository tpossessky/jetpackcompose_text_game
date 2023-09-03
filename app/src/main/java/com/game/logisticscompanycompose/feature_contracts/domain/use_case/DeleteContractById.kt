package com.game.logisticscompanycompose.feature_contracts.domain.use_case

import com.game.logisticscompanycompose.feature_contracts.data.repository.ContractRepository

class DeleteContractById(
    private val repository: ContractRepository
) {

    suspend operator fun invoke(id: Int) {
        //TODO: BUSINESS LOGIC TO ADDING CONTRACT
        repository.deleteContractById(id)
    }
}