package com.game.logisticscompanycompose.feature_contracts.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.game.logisticscompanycompose.feature_contracts.presentation.components.NewContractsList
import com.game.logisticscompanycompose.feature_contracts.presentation.components.OwnedContractsList
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany

@Composable
fun ContractContainer(modifier: Modifier = Modifier, company: LogisticsCompany) {

    var tabIndex by remember { mutableStateOf(0) }
    //TODO: Extract String Resource
    val tabs = listOf("New Contracts", "My Contracts")

    Column(modifier = modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed {index, title ->
                Tab(selected = tabIndex == index, onClick = { tabIndex = index }) {
                    Text(text = title)
                }

            }
        }
        when(tabIndex) {
            0 -> NewContractsList()
            1 -> OwnedContractsList()
        }
    }
}
