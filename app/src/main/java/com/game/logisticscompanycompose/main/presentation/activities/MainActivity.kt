package com.game.logisticscompanycompose.main.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.game.logisticscompanycompose.main.presentation.components.NavigationContainer
import com.game.logisticscompanycompose.main.presentation.viewmodels.MainActivityViewModel
import com.game.logisticscompanycompose.ui.theme.LogisticsCompanyTheme
import com.game.logisticscompanycompose.utils.GameConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : MainActivityViewModel by viewModels()

        val currentCompanyID = intent.getIntExtra(
            GameConstants.EXTRA_FROM_START_TO_MAIN,
            -1
        )

        if(currentCompanyID == -1)
            startActivity(Intent(this, StartActivity::class.java))

        viewModel.setGlobalCompany(currentCompanyID)

        setContent {
            LogisticsCompanyTheme {
                NavigationContainer(
                    companyId = currentCompanyID
                )
            }
        }
    }
}