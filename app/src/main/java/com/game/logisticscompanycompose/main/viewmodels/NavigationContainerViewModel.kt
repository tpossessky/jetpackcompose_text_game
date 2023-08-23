package com.game.logisticscompanycompose.main.viewmodels

import androidx.lifecycle.ViewModel
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.feature_game_management.domain.use_case.GameManagementUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NavigationContainerViewModel @Inject constructor(
    val useCases: GameManagementUseCases
) : ViewModel() {

    private val _companyData = MutableStateFlow<LogisticsCompany?>(null)
    val companyData: StateFlow<LogisticsCompany?> = _companyData

    suspend fun getCompanyById(companyId: Int) {
        // Get the company by ID from the database on a background thread.
        val company = withContext(Dispatchers.IO) {
            useCases.getCompany(companyId)
        }
        _companyData.value = company // Emit the company data to the StateFlow
    }
}