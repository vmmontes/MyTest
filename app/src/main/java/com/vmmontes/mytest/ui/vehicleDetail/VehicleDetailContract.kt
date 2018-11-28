package com.vmmontes.mytest.ui.vehicleDetail

import com.vmmontes.mytest.domain.model.VehicleDomainModel


interface VehicleDetailContract {
    fun addVehicleIntoMap(vehicle : VehicleDomainModel)
}