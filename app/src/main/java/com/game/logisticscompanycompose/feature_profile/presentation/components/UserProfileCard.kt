package com.game.logisticscompanycompose.feature_profile.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.game.logisticscompanycompose.utils.GenericUtils

@Composable
fun UserProfileCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp, pressedElevation = 8.dp
        ),
        shape = RoundedCornerShape(24.dp),

    ) {
        Box(
            Modifier
                .background(
                    brush = GenericUtils.createGradientBrush(
                        Color(0xFF40c9ff),
                        Color(0xFF0061ff)
                    )
                )
                .fillMaxSize()
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.test_svg),
//                contentDescription = "",
//                contentScale = ContentScale.FillWidth)
            Row(modifier = Modifier.padding(16.dp),
                 verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Color.White
                )
                //TODO: Extract String Resource
                Text(
                    text = "My Profile",
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }


}