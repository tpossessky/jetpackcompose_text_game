package com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.logisticscompanycompose.common.user.GlobalCompany
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.model.StaffMember
import com.game.logisticscompanycompose.feature_staff_and_upgrades.domain.use_case.staff.StaffUseCases
import com.game.logisticscompanycompose.feature_staff_and_upgrades.presentation.StaffState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StaffListViewModel @Inject constructor(
    private val staffUseCases: StaffUseCases
) : ViewModel() {

    private val _state = mutableStateOf(StaffState())
    val state : State<StaffState> = _state
    lateinit var company : Flow<LogisticsCompany?>
    private var getStaffJob : Job? = null

    init {
        viewModelScope.launch {
            company = GlobalCompany.getCurrentCompany()
            val id = company.first()!!.id
            staffUseCases.getAllStaff(id)
            getStaff(id)
        }
    }

    private fun getStaff(id: Int) {
        getStaffJob?.cancel()

        getStaffJob = staffUseCases.getAllStaff(id)
            .onEach { staffMembers ->
                _state.value = state.value.copy(
                    staff = staffMembers
                )
            }.launchIn(viewModelScope)

    }


    fun hireStaff(staff: StaffMember) {
        viewModelScope.launch {
            staffUseCases.hireStaff(staff)
        }
    }


    fun fireStaff(staff: StaffMember){
        viewModelScope.launch {
            staffUseCases.fireStaff(staff)
        }
    }

}