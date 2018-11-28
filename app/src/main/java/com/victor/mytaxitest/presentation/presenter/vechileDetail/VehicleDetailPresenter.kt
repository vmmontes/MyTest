package com.victor.mytaxitest.presentation.presenter.vechileDetail

import com.victor.mytaxitest.domain.model.VehicleDomainModel
import com.victor.mytaxitest.ui.vehicleDetail.VehicleDetailContract
import com.victor.mytaxitest.ui.vehicleList.VehicleListContract
import com.victor.mytaxitest.useCases.GetVehiclesList

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