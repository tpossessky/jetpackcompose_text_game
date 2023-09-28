package com.game.logisticscompanycompose.feature_contracts.presentation

import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract

data class ContractState (
    val contractList : List<Contract> = emptyList()
)
