package com.game.logisticscompanycompose.feature_vehicles.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.VehicleUseCases
import com.game.logisticscompanycompose.feature_vehicles.presentation.OwnedVehicleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OwnedVehiclesListViewModel @Inject constructor(
    val gameManagementUseCases: GameManagementUseCases,
    val vehicleUseCases: VehicleUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var getVehiclesJob : Job? = null
    private val id = checkNotNull(savedStateHandle.get<Int>("companyID"))

    private val _state = mutableStateOf(OwnedVehicleState())
    val state : State<OwnedVehicleState> = _state


    init {
        getVehicles()
    }

    private fun getVehicles(){
        getVehiclesJob?.cancel()
        getVehiclesJob = vehicleUseCases.getAllVehiclesByCompanyId(id)
            .onEach { vehicles ->

                _state.value = state.value.copy(
                    vehicles = vehicles,
                )
            }
            .launchIn(viewModelScope)
    }


    fun sellVehicle(vehicle : Vehicle) {
        viewModelScope.launch {
            val company = gameManagementUseCases.getCompany(id)

            vehicleUseCases.sellVehicle(vehicle.id)
            gameManagementUseCases.addCash(
                currentAmt = company!!.cash,
                amountToBeAdded = "2000",
                id = company.id
            )


        }
    }

}