package com.game.logisticscompanycompose.feature_profile.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.game.logisticscompanycompose.feature_game_management.presentation.GameManagementClickEvent
import com.game.logisticscompanycompose.utils.GenericUtils
import com.game.logisticscompanycompose.utils.anim.bounceClick

@Composable
fun SmallCard(
    modifier: Modifier = Modifier,
    text : String,
    icon : ImageVector,
    onClick: (event: GameManagementClickEvent) -> Unit
) {
    Button(
        modifier = modifier
            .height(150.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(32.dp))
            .bounceClick(),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 16.dp,
            pressedElevation = 8.dp
        ),
        //TODO: ONCLICK
        shape = RoundedCornerShape(32.dp),
        onClick = { Log.wtf("Click", "click")},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues()

    ) {
        Box (modifier =
        Modifier
            .background(
                brush = GenericUtils.createGradientBrush(
                    Color(0xFF40c9ff),
                    Color(0xFF0061ff)
                )
            )
            .fillMaxSize(),
            contentAlignment = Alignment.Center

        ){
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.weight(0.8f)
                ) {
                    Icon(
                        modifier = Modifier.size(80.dp),
                        imageVector = icon,
                        contentDescription = "",
                        tint = Color(0x8DFFFFFF)
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        text = text,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}