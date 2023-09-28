package com.game.logisticscompanycompose.feature_contracts.presentation

import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle

sealed class ContractClickEvent {

    data class ContractClickAccept(val contract : Contract) : ContractClickEvent()
    data class ContractClickTerminate(val contract : Contract) : ContractClickEvent()
    data class ContractClickAssignVehicle(val contract : Contract, val vehicle : Vehicle) : ContractClickEvent()

}
