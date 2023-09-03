package com.game.logisticscompanycompose.feature_contracts.domain.use_case

import com.game.logisticscompanycompose.feature_contracts.data.repository.ContractRepository
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract

class UpdateContract (val repository: ContractRepository){

    suspend operator fun invoke(contract: Contract){
        repository.updateContract(contract)
    }
}