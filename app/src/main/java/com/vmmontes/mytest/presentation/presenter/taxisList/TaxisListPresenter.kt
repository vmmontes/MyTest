package com.vmmontes.mytest.presentation.presenter.taxisList

import com.vmmontes.mytest.domain.model.VehicleDomainModel
import com.vmmontes.mytest.ui.vehicleList.VehicleListContract
import com.vmmontes.mytest.domain.useCases.GetVehiclesList
import com.vmmontes.mytest.domain.useCases.GetVehiclesUseCaseCallback
import com.vmmontes.mytest.kernel.coroutines.backgroundContext
import com.vmmontes.mytest.kernel.presentation.CoroutinesPresenter
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TaxisListPresenter: CoroutinesPresenter<VehicleListContract>(), GetVehiclesUseCaseCallback  {

    fun onViewReady() {
        view?.showLoading()
        var vehicles = listOf<VehicleDomainModel>()

        launch {
            async(backgroundContext) {
                vehicles = GetVehiclesList().execute()
            }.await().run{
                if (vehicles.isEmpty()) {
                    onEmpty()
                } else {
                    onSucces(vehicles)
                }
            }
        }
    }

    override fun onSucces(vehicles: List<VehicleDomainModel>) {
        view?.hideLoading()
        view?.showVehiclesList(vehicles)
    }

    override fun onEmpty() {
        view?.hideLoading()
    }
}