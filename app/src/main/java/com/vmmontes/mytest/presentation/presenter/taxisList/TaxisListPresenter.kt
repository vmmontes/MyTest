package com.vmmontes.mytest.presentation.presenter.taxisList

import com.vmmontes.mytest.domain.model.VehicleDomainModel
import com.vmmontes.mytest.ui.vehicleList.VehicleListContract
import com.vmmontes.mytest.useCases.GetVehiclesList
import com.vmmontes.mytest.useCases.GetVehiclesUseCaseCallback

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