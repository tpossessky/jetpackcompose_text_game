package com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.UpgradeAndStaffClickEvent
import com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.view_models.StaffListViewModel

@Composable
fun StaffList(
    modifier: Modifier = Modifier,
    viewModel: StaffListViewModel = hiltViewModel(),
) {
    LazyColumn(modifier = modifier
        .fillMaxSize()
    ) {
        itemsIndexed(viewModel.state.value.staff) { _, staff ->
            StaffItem(staffMember = staff){
                if(it is UpgradeAndStaffClickEvent.StaffClickHire)
                    viewModel.hireStaff(it.staffMember)
                else if(it is UpgradeAndStaffClickEvent.StaffClickFire)
                    viewModel.fireStaff(it.staffMember)
            }
        }
    }
}