package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import kotlinx.coroutines.flow.Flow

class ObserveCompanyUseCase (
    private val repository: LogisticsCompanyRepository
) {

    operator fun invoke(id: Int): Flow<LogisticsCompany?> {
        return repository.observeCompanyByIdFlow(id)
    }
}