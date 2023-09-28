package com.game.logisticscompanycompose.feature_contracts.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_contracts.presentation.view_models.ContractSelectVehicleDialogViewModel
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle

@Composable
fun ContractSelectVehicleDialog(
    onDismissRequest: () -> Unit,
    onConfirm: (Vehicle) -> Unit,
    viewModel: ContractSelectVehicleDialogViewModel = hiltViewModel(),
    contract: Contract
) {

    viewModel.getVehicles()
    /**
     * TODO: user clicks vehicle, update UI to reflect selection and enable De-select btn
     * TODO: then onConfirm(selection : Vehicle) to parent and update DB
     */

    AlertDialog(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 48.dp),
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = "Select Vehicles For Contract", fontWeight = FontWeight.Black)
        },

        text = {
            Column {
                Row{
                    if (!viewModel.finishedInit.value) {
                        CircularProgressIndicator()
                    } else {
                        if(viewModel.availableVehicles.isEmpty()){
                            Text(text = "No available vehicles!")
                        }
                        else {
                            LazyColumn (modifier = Modifier.padding(vertical = 16.dp)) {
                                itemsIndexed(viewModel.availableVehicles) { _, vehicle ->
                                    val isSelected = vehicle == viewModel.selectedItem.value
                                    AddVehicleItem(
                                        vehicle = vehicle,
                                        contract = contract,
                                        isSelected = isSelected)
                                    {
                                        viewModel.onVehicleSelected(vehicle)
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }, confirmButton = {
            Button(onClick = {
                //TODO: If confirm with no vehicle selected
                onConfirm(viewModel.selectedItem.value!!)
                viewModel.dismissConfirm()
            }) {
                Text(text = "Accept Contract")
            }
        }, dismissButton = {
            Button(
                onClick = {
                    onDismissRequest()
                    viewModel.dismiss()
                }
            ) {
                Text(text = "Cancel")
            }
        })
}