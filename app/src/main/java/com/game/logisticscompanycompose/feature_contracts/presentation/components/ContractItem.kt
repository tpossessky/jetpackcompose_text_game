package com.game.logisticscompanycompose.feature_contracts.presentation.components

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_contracts.presentation.ContractClickEvent

@Composable
fun ContractItem(
    modifier: Modifier = Modifier,
    contract : Contract,
    isOwned : Boolean = false,
    onClick : (ContractClickEvent) -> Unit = {}
) {
    //TODO: Extract String Resource
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = contract.issuingCompany)
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Weeks: ${contract.lengthInWeeks}")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Parcels Per Week: ${contract.packagesPerWeek}")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Payment: ${contract.payPerWeek}/week")
        }
        Spacer(modifier = Modifier.height(8.dp))

        if(isOwned){
            Button(onClick = {onClick(ContractClickEvent.ContractClickTerminate(contract))},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ){
                Text(text = "Cancel Contract")
            }
        }
        else {
            Button(onClick = {onClick(ContractClickEvent.ContractClickAccept(contract))},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ){
                Text(text = "Accept Contract")
            }
        }
    }




}