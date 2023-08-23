package com.game.logisticscompanycompose.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.lerp
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object GenericUtils {

    fun convertMillisecondsToDateString(milliseconds: Long) : String =
        SimpleDateFormat.getDateInstance().format(Date(milliseconds))

    fun generateGradientColors(
        numColors: Int,
        startColor: Color,
        endColor: Color
    ): List<Color> {
        return List(numColors) { index ->
            val fraction = index.toFloat() / (numColors - 1).toFloat()
            lerp(startColor, endColor, fraction)
        }
    }

    fun formatCash(cash : String) : String {
        val number = cash.toBigInteger()
        val COUNTRY = "US"
        val LANGUAGE = "en"

        val format = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY))
        format.maximumFractionDigits = 0
        format.minimumFractionDigits = 0
        return format.format(number)
    }

    fun createGradientBrush(
        startColor: Color,
        endColor: Color,
        isVertical: Boolean = true
    ): Brush {
        val colors = generateGradientColors(10, startColor, endColor)
        val endOffset = if (isVertical) {
            Offset(0f, Float.POSITIVE_INFINITY)
        } else {
            Offset(Float.POSITIVE_INFINITY, 0f)
        }

        return Brush.linearGradient(
            colors = colors,
            start = Offset(0f, 0f),
            end = endOffset,
            tileMode = TileMode.Clamp
        )
    }
}

