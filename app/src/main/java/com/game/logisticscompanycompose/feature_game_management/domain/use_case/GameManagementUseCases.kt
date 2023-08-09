package com.game.logisticscompanycompose.feature_game_management.domain.use_case


data class GameManagementUseCases(
    val getCompany: GetCompany,
    val getAllCompanies: GetAllCompanies,
    val deleteCompany: DeleteCompany,
    val addCompany: AddCompany
)