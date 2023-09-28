package com.game.logisticscompanycompose.main.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.common.user.GlobalCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(val gameManagementUseCases: GameManagementUseCases)
    : ViewModel(){

        fun setGlobalCompany(id: Int){
            viewModelScope.launch {
                val company = gameManagementUseCases.observeCompanyUseCase(id)
                if (company != null) {
                    GlobalCompany.setCurrentCompany(company)
                }
            }

        }
}