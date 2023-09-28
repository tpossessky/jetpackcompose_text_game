package com.game.logisticscompanycompose.feature_contracts.presentation.view_models

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.common.user.GlobalCompany
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.VehicleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContractSelectVehicleDialogViewModel @Inject constructor(
    private val vehicleUseCases: VehicleUseCases) : ViewModel(){

    val availableVehicles = mutableListOf<Vehicle>()
    val selectedItem = mutableStateOf<Vehicle?>(null)
    val finishedInit = mutableStateOf(false)


    fun getVehicles() {
        if(availableVehicles.isEmpty()) {
            Log.wtf("ContractSelectVehicleDialogViewModel", "getVehicles called ", )
            getCurrentCompany { company ->
                finishedInit.value = false
                vehicleUseCases.getAllVehiclesByCompanyId(id = company.id, excludeCurrentlyUsed = true)
                    .onEach { vehicles ->
                        availableVehicles.addAll(vehicles)
                        finishedInit.value = true
                    }
                    .launchIn(viewModelScope)
            }
        }
    }

    private fun getCurrentCompany(callback : (LogisticsCompany) -> Unit) {
        viewModelScope.launch {
            val company = GlobalCompany.getCurrentCompany().first()
            callback(company!!)
        }
    }

    fun onVehicleSelected(vehicle: Vehicle) {
        selectedItem.value = vehicle
    }

    fun dismiss() {
        selectedItem.value = null
    }

    fun dismissConfirm() {
        availableVehicles.remove(selectedItem.value)
    }

}