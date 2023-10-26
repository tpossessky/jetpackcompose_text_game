package com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.components

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.Upgrade
import com.game.logisticscompanycompose.utils.anim.bounceClick

@Composable
fun UpgradeItem(
    modifier: Modifier = Modifier,
    upgrade : Upgrade
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
                    text = upgrade.upgradeName,
                    style = TextStyle(
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                //TODO: Extract String Resource
                Text(
                    text = "+10% profit per week",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.bounceClick(),
                    //purchase vehicle
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green
                    )
                ) {
                    //TODO: Extract String Resource
                    Text(
                        text = "$5000",
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

