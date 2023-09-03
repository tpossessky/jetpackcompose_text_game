package com.game.logisticscompanycompose.feature_contracts.domain.use_case

import com.game.logisticscompanycompose.feature_contracts.data.repository.ContractRepository
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract

class DeleteContract(
    private val repository: ContractRepository
) {

    suspend operator fun invoke(contract: Contract) {
        //TODO: BUSINESS LOGIC TO ADDING CONTRACT
        repository.deleteContract(contract)
    }
}