package com.game.logisticscompanycompose.feature_contracts.presentation

import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany

data class ShowContractDialogState(
    var contract : Contract? = null,
    var company : LogisticsCompany? = null
)