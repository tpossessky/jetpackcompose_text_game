package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany

class UpdateCompany(
    private val repository: LogisticsCompanyRepository
) {
    suspend operator fun invoke(company: LogisticsCompany) = repository.updateCompany(company)

}