package com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.common.user.GlobalCompany
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.upgrades.UpgradeUseCases
import com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.UpgradeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpgradeListViewModel @Inject constructor(
    private val upgradeUseCases: UpgradeUseCases
) : ViewModel(){

    private val _state = mutableStateOf(UpgradeState())
    val state : State<UpgradeState> = _state
    lateinit var company : Flow<LogisticsCompany?>
    private var getUpgradesJob : Job? = null


    init {
        viewModelScope.launch {
            company = GlobalCompany.getCurrentCompany()
            val id = company.first()!!.id
            upgradeUseCases.getAllUpgradesByCompanyId(company.first()!!.id)
            getUpgrades(id)

        }
    }

    private fun getUpgrades(id : Int) {
        getUpgradesJob?.cancel()

        getUpgradesJob = upgradeUseCases.getAllUpgradesByCompanyId(id)
            .onEach { upgrades ->
                _state.value = state.value.copy(
                    upgrades = upgrades,
                )
            }
            .launchIn(viewModelScope)
    }



}
