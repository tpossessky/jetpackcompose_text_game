package com.game.logisticscompanycompose.feature_vehicles.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.game.logisticscompanycompose.feature_vehicles.domain.model.PurchasableVehicle
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import com.game.logisticscompanycompose.feature_vehicles.presentation.VehicleClickEvent
import com.game.logisticscompanycompose.ui.theme.LogisticsCompanyTheme
import com.game.logisticscompanycompose.utils.VehicleType
import com.game.logisticscompanycompose.utils.anim.bounceClick

@Composable
fun VehicleItem(
    modifier: Modifier = Modifier,
    vehicle: Vehicle,
    onClick : (VehicleClickEvent) -> Unit = {} //optional onClick parameter
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
                .padding(16.dp),
        ) {
            Row {
                Text(
                    text= vehicle.vehicleType,
                    style = TextStyle(
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            //purchasable vehicle
            if (vehicle is PurchasableVehicle){
                Row {
                    Text(
                        text= "$ ${vehicle.purchasePrice}",
                        style = TextStyle(
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row (
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.bounceClick(),
                        //purchase vehicle
                        onClick = {
                            onClick(VehicleClickEvent.VehicleClickBuy(vehicle))
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Green
                        )
                    ) {
                        Text(
                            text= "Buy",
                            style = TextStyle(
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        )
                    }
                }
            }
            //owned vehicle
            else {
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
                Row {
                    Text(
                        text= "Upgrades: ${vehicle.upgradeTotal}",
                        style = TextStyle(
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        text= vehicle.id.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row (
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.bounceClick(),
                        //sell vehicle
                        onClick = {
                            onClick(VehicleClickEvent.VehicleClickSell(vehicle))
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        )
                    ) {
                        Text(
                            text= "Sell",
                            style = TextStyle(
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        )
                    }
                }
                Row (
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.bounceClick(),
                        //upgrade
                        onClick = {
                            onClick(VehicleClickEvent.VehicleClickUpgrade(vehicle))
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        )
                    ) {
                        Text(
                            text= "Upgrade",
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
        VehicleItem(vehicle = PurchasableVehicle(vehicleType = VehicleType.DELUXE_VAN, purchasePrice = 5000))
    }
}