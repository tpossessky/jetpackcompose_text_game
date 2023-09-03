package com.game.logisticscompanycompose.feature_contracts.domain.use_case

import com.game.logisticscompanycompose.feature_contracts.domain.model.Contract
import com.game.logisticscompanycompose.feature_game_management.domain.model.LogisticsCompany
import com.game.logisticscompanycompose.utils.ContractIssuingCompaniesList
import kotlin.random.Random

class GenerateContracts(private val contractIssuersList : ContractIssuingCompaniesList) {

    operator fun invoke(company : LogisticsCompany) : Contract{

        // Generate a random number of weeks between 1 and 10
        val lengthInWeeks = Random.nextInt(1, 11)
        val packagesPerWeek = (100 * company.level).plus(Random.nextInt(-101, 201))
        val basePaymentPerPackage = 2 * company.level


         return Contract(
            companyId = company.id,
            lengthInWeeks = 4,
            weeksRemaining = lengthInWeeks,
            packagesPerWeek = packagesPerWeek,
            payPerWeek = basePaymentPerPackage,
            issuingCompany = contractIssuersList.invoke().name
         )
    }



}