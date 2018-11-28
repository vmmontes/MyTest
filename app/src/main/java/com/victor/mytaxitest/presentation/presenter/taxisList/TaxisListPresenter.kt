package com.victor.mytaxitest.presentation.presenter.taxisList

import com.victor.mytaxitest.domain.model.VehicleDomainModel
import com.victor.mytaxitest.ui.vehicleList.VehicleListContract
import com.victor.mytaxitest.useCases.GetVehiclesList
import com.victor.mytaxitest.useCases.GetVehiclesUseCaseCallback
import kotlinx.coroutines.Job

class TaxisListPresenter: GetVehiclesUseCaseCallback {

    private lateinit var view: VehicleListContract

    fun onAttach(view: VehicleListContract) {
        this.view = view
    }

    fun onViewReady() {
        view.showLoading()
        GetVehiclesList().execute(this)
    }

    override fun onSucces(vehicles: List<VehicleDomainModel>) {
        view.hideLoading()
        view.showVehiclesList(vehicles)
    }

    override fun onEmpty() {
        view.hideLoading()
    }
}