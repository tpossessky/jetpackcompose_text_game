package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import android.content.Context
import com.game.logisticscompanycompose.R
import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository
import com.game.logisticscompanycompose.feature_game_management.domain.model.InvalidCompanyException
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.utils.resources.ResourceManager
import javax.inject.Inject

class AddCompany @Inject constructor(
    private val repository : LogisticsCompanyRepository,
    private val resourceManager: ResourceManager) {

    @Throws(InvalidCompanyException::class)
    suspend operator fun invoke(company: LogisticsCompany){

        if(company.companyName.isBlank())
            throw InvalidCompanyException(
                resourceManager.getString(R.string.invalid_company_no_title))
        if(company.userName.isBlank())
            throw InvalidCompanyException(
                resourceManager.getString(R.string.invalid_company_no_owner_name))

        repository.insertCompany(company)
    }

}