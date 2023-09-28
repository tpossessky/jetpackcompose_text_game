package com.game.logisticscompanycompose.feature_contracts.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.utils.GenericUtils

@Composable
fun AddVehicleItem(modifier: Modifier = Modifier,
                   contract : Contract,
                   vehicle: Vehicle,
                   isSelected : Boolean,
                   onClick: (Vehicle) -> Unit) {

    val vehicleCapacity = GenericUtils.calculateVehicleCapacity(vehicle)
    Spacer(modifier = Modifier.height(4.dp))
    Card(modifier = modifier.padding(4.dp)) {
        Column(
            modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = vehicle.vehicleType)

            Text(text = "Capacity: $vehicleCapacity/week")
            Text(text = "Currently in conract?: ${vehicle.currentlyUsedInContract}")

            if(contract.packagesPerWeek <= vehicleCapacity){
                if(isSelected){
                    Button(onClick = { onClick(vehicle) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                        Text(text = "Selected")
                    }
                }
                else{
                    Button(onClick = { onClick(vehicle) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                        Text(text = "Select Vehicle")
                    }
                }
            }
            else {
                Button(
                    onClick = {  },
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                    Text(text = "Not Enough Capacity!")
                }
            }
        }
    }

}