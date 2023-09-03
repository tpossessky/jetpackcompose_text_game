package com.game.logisticscompanycompose.main.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.game.logisticscompanycompose.main.presentation.components.StartScreenContainer
import com.game.logisticscompanycompose.ui.theme.LogisticsCompanyTheme
import com.game.logisticscompanycompose.utils.GameConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogisticsCompanyTheme {
                StartScreenContainer{ companyID ->
                    val intent = Intent(this, MainActivity::class.java).apply{
                        putExtra(GameConstants.EXTRA_FROM_START_TO_MAIN, companyID)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}