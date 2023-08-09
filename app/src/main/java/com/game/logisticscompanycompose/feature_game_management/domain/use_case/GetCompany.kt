package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany

class GetCompany(
    private val repository : LogisticsCompanyRepository
) {
    suspend operator fun invoke(id: Int) : LogisticsCompany? = repository.getCompanyById(id)

}