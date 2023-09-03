package com.game.logisticscompanycompose.feature_game_management.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_game_management.presentation.GameManagementClickEvent
import com.game.logisticscompanycompose.utils.GenericUtils
import com.game.logisticscompanycompose.utils.anim.bounceClick

@Composable
fun LoadGameItem(
    company: LogisticsCompany,
    modifier: Modifier = Modifier,
    color: Color,
    onClick: (event: GameManagementClickEvent) -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .bounceClick(),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 16.dp,
            pressedElevation = 8.dp
        ),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        onClick = {onClick(GameManagementClickEvent.GameManagementClickCompany(company.id))},
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues()
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = company.companyName,
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp,
                    color = Color.White
                )
                IconButton(
                    onClick = { onClick(GameManagementClickEvent.GameManagementClickDelete(company.id)) },
                    modifier = Modifier.then(Modifier.size(32.dp))
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
            Text(
                text = company.userName,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.White
            )
            Text(
                text = GenericUtils.formatCash(company.cash),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.White
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = GenericUtils.convertMillisecondsToDateString(company.dateCreated),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}