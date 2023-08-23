package com.game.logisticscompanycompose.main.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.game.logisticscompanycompose.main.components.NavigationContainer
import com.game.logisticscompanycompose.ui.theme.LogisticsCompanyTheme
import com.game.logisticscompanycompose.utils.GameConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentCompanyID = intent.getIntExtra(
            GameConstants.EXTRA_FROM_START_TO_MAIN,
            -1
        )

        if(currentCompanyID == -1)
            startActivity(Intent(this, StartActivity::class.java))


        Log.wtf("MAIN", "ID: $currentCompanyID")
        setContent {
            LogisticsCompanyTheme {
                NavigationContainer(
                    companyId = currentCompanyID
                )
            }
        }
    }
}