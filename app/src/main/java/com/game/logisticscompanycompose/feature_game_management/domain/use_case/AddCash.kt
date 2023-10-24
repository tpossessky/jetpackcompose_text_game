package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository

class AddCash(
    private val repository: LogisticsCompanyRepository
)  {

    suspend operator fun invoke(currentAmt: String, amountToBeAdded : String, id : Int){

        val newAmt = currentAmt.toBigInteger()
            .plus(amountToBeAdded.toBigInteger())
            .toString()

        repository.updateCash(amt = newAmt, id = id)
    }
}