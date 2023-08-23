package com.game.logisticscompanycompose.feature_game_management.presentation.view_models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateDialogViewModel @Inject constructor(
    private val gameManagementUseCases: GameManagementUseCases
) : ViewModel(){

    val companyNameState =  mutableStateOf("")
    val userNameState = mutableStateOf("")
    val selectedCashAmt = mutableStateOf("5000")
}