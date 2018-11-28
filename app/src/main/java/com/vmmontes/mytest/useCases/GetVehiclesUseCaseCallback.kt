package com.vmmontes.mytest.useCases

import com.vmmontes.mytest.domain.model.VehicleDomainModel

interface GetVehiclesUseCaseCallback {
    fun onSucces(vehicles: List<VehicleDomainModel>)
    fun onEmpty()
}