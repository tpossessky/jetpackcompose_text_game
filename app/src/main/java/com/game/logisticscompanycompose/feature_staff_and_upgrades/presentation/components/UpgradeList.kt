package com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.UpgradeAndStaffClickEvent
import com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.view_models.UpgradeListViewModel

@Composable
fun UpgradeList(
    modifier: Modifier = Modifier,
    viewModel: UpgradeListViewModel = hiltViewModel(),
) {
    LazyColumn(modifier = modifier
        .fillMaxSize()
    ) {
        itemsIndexed(viewModel.state.value.upgrades) { _, upgrade ->
            UpgradeItem(upgrade = upgrade){
                if(it is UpgradeAndStaffClickEvent.UpgradeClickBuy)
                    viewModel.purchaseUpgrade(it.upgrade)
            }
        }
    }


}