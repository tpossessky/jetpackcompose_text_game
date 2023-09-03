package com.game.logisticscompanycompose.feature_vehicles.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_vehicles.presentation.VehicleClickEvent
import com.game.logisticscompanycompose.feature_vehicles.presentation.view_models.OwnedVehiclesListViewModel

@Composable
fun OwnedVehiclesList(
    modifier: Modifier = Modifier,
    viewModel: OwnedVehiclesListViewModel = hiltViewModel(),
) {
    LazyColumn(modifier = modifier
        .fillMaxSize()
    ) {
        itemsIndexed(viewModel.state.value.vehicles) { index, vehicle ->
            VehicleItem(vehicle = vehicle){
                if(it is VehicleClickEvent.VehicleClickSell)
                    viewModel.sellVehicle(vehicle)
                else if(it is VehicleClickEvent.VehicleClickUpgrade){
                    viewModel.upgradeVehicle(vehicle)
                }
            }
        }
    }

}