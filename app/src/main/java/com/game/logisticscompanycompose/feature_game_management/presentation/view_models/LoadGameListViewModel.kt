package com.game.logisticscompanycompose.feature_game_management.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import com.game.logisticscompanycompose.feature_game_management.presentation.GameManagementClickEvent
import com.game.logisticscompanycompose.feature_game_management.presentation.SaveGameState
import com.game.logisticscompanycompose.utils.GenericUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadGameListViewModel @Inject constructor(
    private val gameManagementUseCases: GameManagementUseCases
) : ViewModel() {

    private val _state = mutableStateOf(SaveGameState())
    val state : State<SaveGameState> = _state

    val showDeleteDialog = mutableStateOf(false)
    val idToDelete = mutableStateOf(-1)

    private var getGamesJob : Job? = null

    init {
        getGames()
    }

    private fun getGames() {
        getGamesJob?.cancel()
        getGamesJob = gameManagementUseCases.getAllCompanies()
            .onEach { games ->
                val colors = GenericUtils.generateGradientColors(
                    games.size,
                    //TODO: COLOR
                    Color(0xFF40c9ff),
                    Color(0xFF0061ff)
                )
                _state.value = state.value.copy(
                    games = games,
                    colors = colors
                )
            }
            .launchIn(viewModelScope)
    }

    fun onEvent(gameManagementClickEvent: GameManagementClickEvent) {
        when(gameManagementClickEvent) {
            is GameManagementClickEvent.GameManagementClickCompany ->{
                //TODO: Load Company
            }
            is GameManagementClickEvent.ConfirmDelete -> {
                viewModelScope.launch {
                    gameManagementUseCases.deleteCompany.invoke(idToDelete.value)
                }
            }
            else ->{}
        }
    }
}