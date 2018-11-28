package com.vmmontes.mytest.useCases

import com.vmmontes.mytest.dataSource.ApiData
import com.vmmontes.mytest.domain.model.VehicleDomainModel
import kotlinx.coroutines.*

class GetVehiclesList{

    fun execute(callback: GetVehiclesUseCaseCallback) {
        var vehicles = listOf<VehicleDomainModel>()

        GlobalScope.launch(Dispatchers.Main) {
            async(Dispatchers.IO) {
                vehicles = ApiData().getVehicles()

            }.await().run {
                if (vehicles.isEmpty()) {
                    callback.onEmpty()
                } else {
                    callback.onSucces(vehicles)
                }
            }
        }

    }
}
