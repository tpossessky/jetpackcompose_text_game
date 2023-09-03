package com.game.logisticscompanycompose.feature_game_management.domain.use_case

import android.util.Log
import com.game.logisticscompanycompose.feature_game_management.data.repository.LogisticsCompanyRepository

class SubtractCash(
    private val repository: LogisticsCompanyRepository
)  {

    suspend operator fun invoke(currentAmt: String, amountToBeSubtracted : String, id : Int){

        val newAmt = currentAmt.toBigInteger()
            .minus(amountToBeSubtracted.toBigInteger())
            .toString()

        Log.wtf("USE CASE", "CURRENT CASH = $currentAmt" +
                "\t AMT TO SUBTRACT = $amountToBeSubtracted" +
                "\t NEW AMT $newAmt")

        repository.updateCash(amt = newAmt, id = id)
    }
}