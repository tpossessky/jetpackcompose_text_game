package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import com.game.logisticscompanycompose.R
import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.model.InvalidCompanyException
import com.game.logisticscompanycompose.feature_game_management.domain.model.InvalidCompanyNameException
import com.game.logisticscompanycompose.feature_game_management.domain.model.InvalidOwnerNameException
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.utils.resources.ResourceManager

class AddCompany(
    private val repository: LogisticsCompanyRepository,
    private val resourceManager: ResourceManager
) {

    @Throws(InvalidCompanyException::class)
    suspend operator fun invoke(company: LogisticsCompany) : Long {

        if (company.companyName.isBlank())
            throw InvalidCompanyNameException(
                resourceManager.getString(R.string.invalid_company_no_title)
            )
        if (company.userName.isBlank())
            throw InvalidOwnerNameException(
                resourceManager.getString(R.string.invalid_company_no_owner_name)
            )

        return repository.insertCompany(company)
    }
}