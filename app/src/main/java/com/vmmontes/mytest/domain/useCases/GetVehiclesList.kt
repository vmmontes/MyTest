package com.vmmontes.mytest.domain.useCases

import com.vmmontes.mytest.data.VehiclesRepositoryImp
import com.vmmontes.mytest.domain.model.VehicleDomainModel

class GetVehiclesList{
    fun execute(): List<VehicleDomainModel> = VehiclesRepositoryImp().getVehicles()
}
