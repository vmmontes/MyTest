package com.victor.mytaxitest.ui.vehicleList

import com.victor.mytaxitest.domain.model.VehicleDomainModel

interface VehicleListContract {

    fun showVehiclesList(vehiclesList: List<VehicleDomainModel>)
    fun showLoading()
    fun hideLoading()
}