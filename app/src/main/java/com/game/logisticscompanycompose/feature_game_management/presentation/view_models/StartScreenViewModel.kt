package com.game.logisticscompanycompose.feature_game_management.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.feature_game_management.domain.model.InvalidCompanyException
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartScreenViewModel @Inject constructor(
    private val useCases: GameManagementUseCases
): ViewModel(){

    val showCreateDialog = mutableStateOf(false)

    private val _exception = mutableStateOf<InvalidCompanyException?>(null)
    val exception: State<InvalidCompanyException?> = _exception

    private val _newCompanyId = MutableStateFlow<Int?>(null)
    val newCompanyId: Flow<Int?> = _newCompanyId.filterNotNull()

    fun onCreateCompany(company: LogisticsCompany) {
        viewModelScope.launch {
            try {
                showCreateDialog.value = false
                val id = useCases.addCompany(company).toInt()
                _newCompanyId.emit(id)
            } catch (e: InvalidCompanyException) {
                _exception.value = e
            }
        }
    }
}