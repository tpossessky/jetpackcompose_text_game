package com.game.logisticscompanycompose.feature_vehicles.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import com.game.logisticscompanycompose.feature_vehicles.domain.model.PurchasableVehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.model.PurchasableVehiclesCollection
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.use_case.VehicleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PurchaseVehicleListViewModel @Inject constructor(
    private val useCases: VehicleUseCases,
    private val gameManagementUseCases: GameManagementUseCases
) : ViewModel() {

    fun purchaseVehicle(vehicle: PurchasableVehicle, id: Int) {

        viewModelScope.launch {
            val company = gameManagementUseCases.getCompany(id)

            val newVehicle = Vehicle(
                vehicleType = vehicle.vehicleType,
                companyId = id
            )

            useCases.addVehicle(newVehicle)

            gameManagementUseCases.subtractCash.invoke(
                currentAmt = company!!.cash,
                amountToBeSubtracted = vehicle.purchasePrice.toString(),
                id = company.id
            )
        }
    }

    val vehicleList: List<PurchasableVehicle> = mutableListOf<PurchasableVehicle>().apply {
        addAll(PurchasableVehiclesCollection.list)
    }

}