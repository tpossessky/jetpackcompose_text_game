package com.game.logisticscompanycompose.feature_profile.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.game.logisticscompanycompose.R

@Composable
fun CardGrid(modifier: Modifier = Modifier) {

    //ALERT: MINIMUM HEIGHT FOR CARD TO LOOK GOOD IS 75dp
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SmallCard(
            modifier =  Modifier.weight(1f),
            text = "Settings",
            icon = Icons.Default.Settings,
            onClick = {Log.wtf("CLICK", "CLICK")}
        )
        SmallCard(
            modifier =  Modifier.weight(1f),
            text = "Store",
            icon = ImageVector.vectorResource(id = R.drawable.store_24),
            onClick = {Log.wtf("CLICK", "CLICK")}

        )
    }
}