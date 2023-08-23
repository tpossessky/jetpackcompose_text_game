package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository

class DeleteCompany(
    private val repository: LogisticsCompanyRepository
) {
    suspend operator fun invoke(id: Int) = repository.deleteCompanyByID(id = id)
}