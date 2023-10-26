package com.game.logisticscompanycompose.feature_game_management.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_game_management.domain.model.InvalidCompanyException
import com.game.logisticscompanycompose.feature_game_management.domain.model.InvalidCompanyNameException
import com.game.logisticscompanycompose.feature_game_management.domain.model.InvalidOwnerNameException
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_game_management.presentation.view_models.CreateDialogViewModel
import com.game.logisticscompanycompose.utils.GameConstants

@Composable
fun CreateGameDialog(
    onConfirm: (company: LogisticsCompany) -> Unit,
    onDismissRequest: () -> Unit,
    viewModel: CreateDialogViewModel = hiltViewModel(),
    errorType: InvalidCompanyException?
) {
    val options = GameConstants.createCompanyStartingCashOptions
//TODO: Extract String Resource
    AlertDialog(onDismissRequest = onDismissRequest, title = {
        Text(text = "Create New Game", fontWeight = FontWeight.Black)
    }, text = {
        Column {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Company Name",
                fontWeight = FontWeight.SemiBold
            )
            TextField(value = viewModel.companyNameState.value,
                onValueChange = { viewModel.companyNameState.value = it },
                isError = errorType is InvalidCompanyNameException,
                singleLine = true,
                supportingText = {
                    if (errorType is InvalidCompanyNameException) {
                        Text(text = errorType.message!!)
                    }
                })

            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                text = "Owner Name",
                fontWeight = FontWeight.SemiBold
            )
            TextField(value = viewModel.userNameState.value,
                onValueChange = { viewModel.userNameState.value = it },
                singleLine = true,
                isError = errorType is InvalidOwnerNameException,
                supportingText = {
                    if (errorType is InvalidOwnerNameException) {
                        Text(text = errorType.message!!)
                    }
                })
            Text(
                modifier = Modifier.padding(top = 16.dp), text = "Starting Cash"
            )
            CreateCompanyRadioGroup(
                modifier = Modifier.padding(top = 16.dp),
                options = options,
                selectedOption = viewModel.selectedCashAmt.value
            ) { selectedOption ->
                viewModel.selectedCashAmt.value = selectedOption
            }
        }
    }, confirmButton = {
        Button(onClick = {
            onConfirm(
                LogisticsCompany(
                    companyName = viewModel.companyNameState.value,
                    userName = viewModel.userNameState.value,
                    cash = viewModel.selectedCashAmt.value,
                )
            )
        }) {
            Text(text = "Create")
        }
    }, dismissButton = {
        Button(
            onClick = onDismissRequest
        ) {
            Text(text = "Cancel")
        }
    })
}