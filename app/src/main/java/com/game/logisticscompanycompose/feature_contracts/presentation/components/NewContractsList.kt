package com.game.logisticscompanycompose.feature_contracts.presentation.components


import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_contracts.presentation.ContractClickEvent
import com.game.logisticscompanycompose.feature_contracts.presentation.view_models.NewContractsListViewModel

@Composable
fun NewContractsList(
    modifier: Modifier = Modifier,
    viewModel: NewContractsListViewModel = hiltViewModel(),
) {
    val showDialog = viewModel.showCreateDialog.value

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ){
        itemsIndexed(viewModel.state.value.contractList){ _, contract ->
            ContractItem(contract = contract){
                if(it is ContractClickEvent.ContractClickAccept){
                    viewModel.onClickAccept(it.contract)
                    Log.wtf("", "NewContractsList: clicky")
                    viewModel.showCreateDialog.value = true
                }
            }
        }
    }
    if(showDialog){
        ContractSelectVehicleDialog(
            contract = viewModel.dialogState.value.contract!!,
            onDismissRequest = {
                viewModel.dismissDialog()
            },
            onConfirm = {
                viewModel.addContractToCompany(it)
            }
        )
    }
}
