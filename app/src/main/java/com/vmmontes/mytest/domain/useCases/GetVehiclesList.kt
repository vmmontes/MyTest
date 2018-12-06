package com.vmmontes.mytest.domain.useCases

import com.vmmontes.mytest.data.VehiclesRepositoryImp
import com.vmmontes.mytest.domain.model.VehicleDomainModel
import kotlinx.coroutines.*

class GetVehiclesList{

    fun execute(callback: GetVehiclesUseCaseCallback) {
        var vehicles = listOf<VehicleDomainModel>()

        GlobalScope.launch(Dispatchers.Main) {
            async(Dispatchers.IO) {
                vehicles = VehiclesRepositoryImp().getVehicles()

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
