package com.victor.mytaxitest.ui.vehicleDetail

import com.victor.mytaxitest.domain.model.VehicleDomainModel


interface VehicleDetailContract {
    fun addVehicleIntoMap(vehicle : VehicleDomainModel)
}