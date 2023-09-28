package com.game.logisticscompanycompose.feature_contracts.presentation.view_models

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.common.user.GlobalCompany
import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_contracts.domain.use_case.ContractUseCases
import com.game.logisticscompanycompose.feature_contracts.presentation.ContractState
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OwnedContractsViewModel @Inject constructor(
    private val contractUseCases: ContractUseCases) : ViewModel(){

    private val _state = mutableStateOf(ContractState())
    val state: State<ContractState> = _state

    private val _ownedContracts = MutableStateFlow<List<Contract>>(emptyList())
    val ownedContracts: StateFlow<List<Contract>> = _ownedContracts.asStateFlow()


    init {
        Log.wtf("OwnedContractsViewModel", "Init", )
        viewModelScope.launch {
            val it = GlobalCompany.getCurrentCompany().first()
            getContracts(it!!)
        }
    }


    private fun getContracts(company: LogisticsCompany) {
        contractUseCases.getContractsByCompanyId(company.id)
            .onEach { contracts ->
                val updatedContracts = ownedContracts.value.toMutableList()
                updatedContracts.addAll(contracts)
                _ownedContracts.value = updatedContracts // Update the StateFlow
            }
            .launchIn(viewModelScope)
    }


//    private fun getCurrentCompany(callback : (LogisticsCompany) -> Unit) {
//        viewModelScope.launch {
//            val company = GlobalCompany.getCurrentCompany().first()
//            callback(company!!)
//        }
//    }


    fun onTerminate(contract: Contract){
        viewModelScope.launch {
//            contractUseCases.deleteContract(contract)
        }
    }
}