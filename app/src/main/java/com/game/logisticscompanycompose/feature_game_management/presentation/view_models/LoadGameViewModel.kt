package com.game.logisticscompanycompose.feature_game_management.presentation.view_models

import androidx.lifecycle.ViewModel
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoadGameViewModel @Inject constructor(
    private val gameManagementUseCases: GameManagementUseCases
) : ViewModel() {

//    val showCreateDialog = mutableStateOf(false)
//
//    private val _exception = mutableStateOf<InvalidCompanyException?>(null)
//    val exception: State<InvalidCompanyException?> = _exception

//    fun onCreateCompany(company: LogisticsCompany) {
//        viewModelScope.launch {
//            try {
//                gameManagementUseCases.addCompany(company)
//                showCreateDialog.value = false
//                //TODO: Should probably navigate to home screen when creating new game
//            } catch (e: InvalidCompanyException) {
//                _exception.value = e
//            }
//        }
//    }
}