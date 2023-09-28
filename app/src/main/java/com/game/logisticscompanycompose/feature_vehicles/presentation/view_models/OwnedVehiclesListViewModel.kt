package com.game.logisticscompanycompose.feature_vehicles.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.common.user.GlobalCompany
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.VehicleUseCases
import com.game.logisticscompanycompose.feature_vehicles.presentation.OwnedVehicleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OwnedVehiclesListViewModel @Inject constructor(
    val gameManagementUseCases: GameManagementUseCases,
    private val vehicleUseCases: VehicleUseCases,
) : ViewModel() {

    private var getVehiclesJob : Job? = null
    private var id : Int = -1

    private val _state = mutableStateOf(OwnedVehicleState())
    val state : State<OwnedVehicleState> = _state
    lateinit var company : Flow<LogisticsCompany?>

    init {
        viewModelScope.launch {
            company = GlobalCompany.getCurrentCompany()
            id = company.first()!!.id
            getVehicles()

        }
    }


    //TODO: Move pricing logic to domain level
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


    //TODO: accurate pricing
    fun sellVehicle(vehicle : Vehicle) {
        viewModelScope.launch {
            val company = gameManagementUseCases.getCompany(id)

            vehicleUseCases.sellVehicle(vehicle.id)
            gameManagementUseCases.addCash(
                currentAmt = company!!.cash,
                amountToBeAdded = "5000",
                id = company.id
            )
        }
    }

    //TODO: Add logic to do something with vehicle upgrades
    fun upgradeVehicle(vehicle: Vehicle) {
        viewModelScope.launch {
            val total = vehicle.upgradeTotal
            vehicle.upgradeTotal += 1

            vehicleUseCases.updateVehicle(vehicle)
        }
    }
}