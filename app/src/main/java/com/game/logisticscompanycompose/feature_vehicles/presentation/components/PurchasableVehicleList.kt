package com.game.logisticscompanycompose.feature_vehicles.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_vehicles.presentation.VehicleClickEvent
import com.game.logisticscompanycompose.feature_vehicles.presentation.view_models.PurchaseVehicleListViewModel

@Composable
fun PurchasableVehicleList(
    modifier: Modifier = Modifier,
    viewModel: PurchaseVehicleListViewModel = hiltViewModel(),
    company: LogisticsCompany
) {
    LazyColumn(modifier = modifier
        .fillMaxSize()
    ) {
        itemsIndexed(viewModel.vehicleList) { index, vehicle ->
            VehicleItem(vehicle = vehicle){
                if(it is VehicleClickEvent.VehicleClickBuy)
                    viewModel.purchaseVehicle(it.vehicle, company.id)
            }
        }
    }

}