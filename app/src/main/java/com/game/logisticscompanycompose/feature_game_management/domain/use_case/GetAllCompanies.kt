package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllCompanies(
    private val repository: LogisticsCompanyRepository
) {
    operator fun invoke(): Flow<List<LogisticsCompany>> {

        //return companies in order by most recently created
        return repository.getCompanies().map { companies ->
            companies.sortedByDescending { it.dateCreated }
        }

    }
}