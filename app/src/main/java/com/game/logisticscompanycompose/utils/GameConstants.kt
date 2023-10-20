package com.game.logisticscompanycompose.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import com.game.logisticscompanycompose.R
import javax.inject.Inject
import kotlin.random.Random


object GameConstants {
    val createCompanyStartingCashOptions = listOf("5000", "10000", "15000")

    //DataStore names
    const val DATASTORE_SETTINGS_FILE = "user_settings"
    val DATASTORE_THEME_KEY = intPreferencesKey("theme")
    val DATASTORE_NOTIF_KEY = booleanPreferencesKey("notif")


    //Intent Extra
    const val EXTRA_FROM_START_TO_MAIN = "company_extra"


    enum class JOBCODE (val code : Int){

        DispatchManager(0),
        SalesRep(1),
        ChiefMarketingOfficer(2),
        ChiefFinancialOfficer(3),

    }









    enum class UPGRADECODE(val code: Int){
        Speed(0),
        Pay(1),
    }



    enum class UPGRADE (val upgradeName : String, val code : UPGRADECODE, val percentIncrease: Double){
        AutomatedSorting("Automated Sorting", UPGRADECODE.Speed, 0.1),
        PackageTracking("Package Tracking", UPGRADECODE.Pay, 0.1),
        OptimizedRoutes("Optimized Routes", UPGRADECODE.Speed, 0.1),
        RoboticSorting("Robotic Sorting", UPGRADECODE.Speed, 0.1),
        QuantumPackageTransportation("Quantum Package Transportation", UPGRADECODE.Speed, 0.1)
    }
}



object VehicleType {
    const val VAN = "Van"
    const val DELUXE_VAN = "Deluxe Van"
    const val TRUCK = "Truck"
    const val PICKUP_TRUCK = "Pickup Truck"
}
enum class JOBCODE (val code : Int){

    DispatchManager(0),
    SalesRep(1),
    ChiefMarketingOfficer(2),
    ChiefFinancialOfficer(3),

}

data class ContractIssuingCompany(
    val name: String,
    val imageResourceId: Int
)

class ContractIssuingCompaniesList @Inject constructor(context : Context){
    val companyList: List<ContractIssuingCompany> = listOf(
        ContractIssuingCompany(context.getString(R.string.blossom_bloom_florist), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.techmaster_solutions), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.golden_gate_coffee_co), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.atlas_construction), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.pacific_waves_surf_shop), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.luna_s_baked_goods), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.stellar_designs), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.velocity_auto_repair), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.oak_ivy_furniture), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.evergreen_pet_care), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.fashion_house_boutique), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.brew_haven_craft_beverages), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.artisanal_delights), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.blissful_bites_catering), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.tech_hub_it_solutions), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.the_fitness_warehouse), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.whisk_and_whistle_bakery), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.clear_skies_cleaning_supplies), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.art_n_stuff_supply_co), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.harvest_acres_farms), R.drawable.car),
        ContractIssuingCompany(context.getString(R.string.johnson_grocery), R.drawable.car),
    )

    operator fun invoke(): ContractIssuingCompany {
        val randomIndex = Random.nextInt(companyList.size)
        return companyList[randomIndex]
    }
}