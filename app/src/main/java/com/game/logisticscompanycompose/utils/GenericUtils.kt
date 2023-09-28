package com.game.logisticscompanycompose.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.lerp
import com.game.logisticscompanycompose.feature_vehicles.domain.model.Vehicle
import java.math.BigInteger
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

object GenericUtils {

    /**
     * Creates a SimpleDateFormat String from milliseconds
     */
    fun convertMillisecondsToDateString(milliseconds: Long) : String =
        SimpleDateFormat.getDateInstance().format(Date(milliseconds))


    /**
     * Generates a gradient list between 2 colors and a # of elements
     * @param numColors Number of colors to create
     * @param startColor Start of gradient
     * @param endColor End of gradient
     */
    fun generateGradientColors(
        numColors: Int,
        startColor: Color,
        endColor: Color
    ): List<Color> {
        return if(numColors > 1) {
            List(numColors) { index ->
                val fraction = index.toFloat() / (numColors - 1).toFloat()
                lerp(startColor, endColor, fraction)
            }
        }else {
            listOf(startColor)
        }
    }

    /**
     * UI function for displaying the cash correctly
     */
    fun formatCash(cash: String): String {
        val number = cash.toBigInteger()
        val COUNTRY = "US"
        val LANGUAGE = "en"

        // Check if the number is larger than a billion
        if (number >= BigInteger("1000000000")) {
            val thresholds = mapOf(
                BigInteger("1000000000000") to "T",
                BigInteger("1000000000") to "B",
                BigInteger("1000000") to "M"
            )

            //handles the decimals
            for ((threshold, suffix) in thresholds) {
                if (number >= threshold) {
                    val formattedNumber = number.toDouble() / threshold.toDouble()
                    val format = NumberFormat.getNumberInstance(Locale(LANGUAGE, COUNTRY))
                    format.maximumFractionDigits = 2
                    format.minimumFractionDigits = 2
                    return "${format.format(formattedNumber)}$suffix"
                }
            }
        }

        val format = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY))
        format.maximumFractionDigits = 0
        format.minimumFractionDigits = 0

        return format.format(number)
    }




    /**
     * Creates a Brush with a list of gradient colors
     * @see generateGradientColors()
     */
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

    fun calculateVehicleCapacity(vehicle : Vehicle) : Int {

        val type = vehicle.vehicleType
        val upgradeLevel = vehicle.upgradeTotal
        var capacity = 0

        when(type) {
            VehicleType.PICKUP_TRUCK -> {
                capacity = (0.1 * upgradeLevel).roundToInt().plus(200)
            }
            VehicleType.VAN -> {
                capacity = (0.1 * upgradeLevel).roundToInt().plus(400)
            }
            VehicleType.DELUXE_VAN -> {
                capacity = (0.1 * upgradeLevel).roundToInt().plus(600)
            }
            VehicleType.TRUCK -> {
                capacity = (0.1 * upgradeLevel).roundToInt().plus(800)
            }
        }
        return capacity
    }




}