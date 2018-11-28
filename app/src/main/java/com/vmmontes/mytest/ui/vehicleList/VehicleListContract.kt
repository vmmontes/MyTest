package com.vmmontes.mytest.ui.vehicleList

import com.vmmontes.mytest.domain.model.VehicleDomainModel

interface VehicleListContract {

    fun showVehiclesList(vehiclesList: List<VehicleDomainModel>)
    fun showLoading()
    fun hideLoading()
}