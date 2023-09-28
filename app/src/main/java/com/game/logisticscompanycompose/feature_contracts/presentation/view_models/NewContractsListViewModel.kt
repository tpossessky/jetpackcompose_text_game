package com.game.logisticscompanycompose.feature_contracts.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.common.user.GlobalCompany
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.ContractUseCases
import com.game.logisticscompanycompose.feature_contracts.presentation.ContractState
import com.game.logisticscompanycompose.feature_contracts.presentation.ShowContractDialogState
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.VehicleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewContractsListViewModel @Inject constructor(
    private val contractUseCases: ContractUseCases,
    private val vehicleUseCases: VehicleUseCases,
) : ViewModel() {


    private val _state = mutableStateOf(ContractState())
    val state : State<ContractState> = _state
    val showCreateDialog = mutableStateOf(false)

    val dialogState = mutableStateOf(ShowContractDialogState())
    init {
        getNewContracts()
        getCurrentCompany {

        }
    }

    private fun getCurrentCompany(callback : (LogisticsCompany) -> Unit) {
        viewModelScope.launch {
            val company = GlobalCompany.getCurrentCompany().first()
            callback(company!!)
        }
    }


    //do like the other vm for getting the company with a lambda and change onClickAccept
    private fun getNewContracts(){
        viewModelScope.launch {
            val contracts =
                contractUseCases.generateContracts.invoke(GlobalCompany.getCurrentCompany().first()!!, 3)
            _state.value = state.value.copy(contractList = contracts)
        }
    }

    fun onClickAccept(contract: Contract) {
        dialogState.value.contract = contract
        getCurrentCompany {
            dialogState.value.company = it
        }
    }

    fun dismissDialog(){
        dialogState.value.contract = null
        dialogState.value.company = null
        showCreateDialog.value = false
    }

    //TODO: Move vehicle logic to domain layer
    fun addContractToCompany(vehicle: Vehicle) {
        val selectedContract = dialogState.value.contract

        viewModelScope.launch {
            selectedContract?.let {
                // Add the vehicle to the selected contract
                it.vehicleId = vehicle.id

                vehicle.currentlyUsedInContract = true

                contractUseCases.addContract(
                    Contract(
                        issuingCompany = it.issuingCompany,
                        lengthInWeeks = it.lengthInWeeks,
                        weeksRemaining = it.weeksRemaining,
                        payPerWeek = it.payPerWeek,
                        packagesPerWeek = it.packagesPerWeek,
                        companyId = it.companyId,
                        vehicleId = vehicle.id
                    )
                )
                // Update the vehicle in the database
                vehicleUseCases.updateVehicle(vehicle)

                // Now, remove the selected contract from the list
                val updatedContracts = state.value.contractList.toMutableList()
                updatedContracts.remove(it)

                // Update the state with the modified contract list
                _state.value = state.value.copy(contractList = updatedContracts)

                // Clear the dialog state
                dismissDialog()
            }
        }
    }


}