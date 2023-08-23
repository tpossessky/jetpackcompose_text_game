package com.game.logisticscompanycompose.feature_vehicles.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.game.logisticscompanycompose.feature_vehicles.domain.model.PurchasableVehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.ui.theme.LogisticsCompanyTheme

@Composable
fun VehicleCard(
    modifier: Modifier = Modifier,
    vehicle: Vehicle
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Row {
                Text(
                    text= vehicle.vehicleType,
                    style = TextStyle(
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            when(vehicle) {
                is PurchasableVehicle ->{
                    Row {
                        Text(
                            text= vehicle.purchasePrice.toString(),
                            style = TextStyle(
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        )
                    }
                }
            }


        }


    }


}

@Preview
@Composable
fun CardPreview(){
    LogisticsCompanyTheme {
        VehicleCard(vehicle = Vehicle(vehicleType = "Van", companyId = 4, upgradeTotal = 0 ))
    }
}