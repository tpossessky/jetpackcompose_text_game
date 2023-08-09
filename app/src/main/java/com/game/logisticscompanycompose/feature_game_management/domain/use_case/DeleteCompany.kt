package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import javax.inject.Inject

class DeleteCompany @Inject constructor(
    private val repository: LogisticsCompanyRepository
) {
    suspend operator fun invoke(company : LogisticsCompany) = repository.deleteCompany(company)
}