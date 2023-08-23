package com.game.logisticscompanycompose.utils

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey


object GameConstants {
    val createCompanyStartingCashOptions = listOf("5000", "10000", "20000")

    //DataStore names
    const val DATASTORE_SETTINGS_FILE = "user_settings"
    val DATASTORE_THEME_KEY = intPreferencesKey("theme")
    val DATASTORE_NOTIF_KEY = booleanPreferencesKey("notif")


    //Intent Extra
    const val EXTRA_FROM_START_TO_MAIN = "company_extra"


//    open class InvalidCompanyException(message: String) : Exception(message)
//
//    class InvalidCompanyNameException(message: String) : InvalidCompanyException(message)
//    class InvalidOwnerNameException(message: String) : InvalidCompanyException(message)

}

object VehicleType {
    const val VAN = "Van"
    const val DELUXE_VAN = "Deluxe Van"
    const val TRUCK = "Truck"
    const val PICKUP_TRUCK = "Pickup Truck"
}