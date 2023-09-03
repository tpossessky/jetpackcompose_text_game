package com.game.logisticscompanycompose.feature_vehicles.domain.model

import com.game.logisticscompanycompose.utils.VehicleType

data class PurchasableVehicle(
    override val vehicleType: String = "",
    val purchasePrice: Int = 0,
    val unlockLevel: Int = 0
) : Vehicle(
    id = -1,
    vehicleType = vehicleType,
    upgradeTotal = 0,
    companyId = -1,
    currentlyUsedInContract = false
)


object PurchasableVehiclesCollection {

    val Van = PurchasableVehicle(
        vehicleType = VehicleType.VAN,
        purchasePrice = 5000,
        unlockLevel = 5
    )

    val DeluxeVan = PurchasableVehicle(
        vehicleType = VehicleType.DELUXE_VAN,
        purchasePrice = 10000,
        unlockLevel = 10
    )

    val PickupTruck = PurchasableVehicle(
        vehicleType = VehicleType.PICKUP_TRUCK,
        purchasePrice = 2000,
        unlockLevel = 1
    )

    val Truck = PurchasableVehicle(
        vehicleType = VehicleType.TRUCK,
        purchasePrice = 12500,
        unlockLevel = 1
    )

    val list = listOf(Van, DeluxeVan, PickupTruck, Truck).sortedBy {
        it.purchasePrice
    }

}