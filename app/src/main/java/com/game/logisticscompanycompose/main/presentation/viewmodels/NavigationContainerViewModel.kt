package com.game.logisticscompanycompose.main.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NavigationContainerViewModel @Inject constructor(
    private val useCases: GameManagementUseCases
) : ViewModel() {

    private val _companyData: MutableStateFlow<LogisticsCompany?> = MutableStateFlow(null)
    val companyData: StateFlow<LogisticsCompany?> = _companyData

    fun setCompanyIdAndObserve(id: Int) {
        useCases.observeCompanyUseCase(id)
            .onEach { company ->
                _companyData.value = company
            }
            .launchIn(viewModelScope)
    }
}