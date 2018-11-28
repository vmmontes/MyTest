package com.vmmontes.mytest.presentation.presenter.vechileDetail

import com.vmmontes.mytest.domain.model.VehicleDomainModel
import com.vmmontes.mytest.ui.vehicleDetail.VehicleDetailContract

class VehicleDetailPresenter {

    private lateinit var view: VehicleDetailContract
    private lateinit var vehicle : VehicleDomainModel

    fun onAttach(view: VehicleDetailContract, vehicle : VehicleDomainModel) {
        this.view = view
        this.vehicle = vehicle
    }

    fun onViewReady() {

    }

    fun mapIsReady() {
        view.addVehicleIntoMap(vehicle)
    }
}