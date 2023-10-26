package com.game.logisticscompanycompose.main.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.game.logisticscompanycompose.utils.GenericUtils
import java.math.BigInteger

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCashText(count: BigInteger) {

    var oldCount by remember {
        mutableStateOf(count)
    }

    SideEffect {
        oldCount = count
    }

    Row(){
        val countString = count.toString()
        val oldCountString = oldCount.toString()

        for(i in countString.indices){
            val oldChar = oldCountString.getOrNull(i)
            val newChar = countString[i]

            val char =
                if(oldChar == newChar)
                    oldCountString[i]
                else
                    countString[i]

            AnimatedContent(
                targetState = char,
                label = "",
                transitionSpec = {
                    slideInVertically {it} with slideOutVertically { -it }
                }

            ) {scopedChar ->
                Text(text = GenericUtils.formatCash(scopedChar.toString()), softWrap = false)
            }
        }
    }
}