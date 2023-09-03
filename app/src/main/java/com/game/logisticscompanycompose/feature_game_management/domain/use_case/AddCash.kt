package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import android.util.Log
import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository

class AddCash(
    private val repository: LogisticsCompanyRepository
)  {

    suspend operator fun invoke(currentAmt: String, amountToBeAdded : String, id : Int){

        val newAmt = currentAmt.toBigInteger()
            .plus(amountToBeAdded.toBigInteger())
            .toString()

        Log.wtf("USE CASE", "CURRENT CASH = $currentAmt" +
                "\t AMT TO ADD = $amountToBeAdded" +
                "\t NEW AMT $newAmt")

        repository.updateCash(amt = newAmt, id = id)
    }
}