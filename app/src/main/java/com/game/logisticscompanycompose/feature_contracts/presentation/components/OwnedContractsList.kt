package com.game.logisticscompanycompose.feature_contracts.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_contracts.presentation.ContractClickEvent
import com.game.logisticscompanycompose.feature_contracts.presentation.view_models.OwnedContractsViewModel

@Composable
fun OwnedContractsList(
    modifier: Modifier = Modifier,
    viewModel: OwnedContractsViewModel = hiltViewModel(),
) {
    val ownedContracts by viewModel.ownedContracts.collectAsState()

    if(ownedContracts.isEmpty())
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    else{
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            itemsIndexed(ownedContracts) { _, contract ->
                ContractItem(contract = contract, isOwned = true) {
                    if (it is ContractClickEvent.ContractClickTerminate) {
                        viewModel.onTerminate(it.contract)

                    }
                }
            }
        }
    }
}