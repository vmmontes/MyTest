package com.victor.mytaxitest.useCases

import com.victor.mytaxitest.domain.model.VehicleDomainModel

interface GetVehiclesUseCaseCallback {
    fun onSucces(vehicles: List<VehicleDomainModel>)
    fun onEmpty()
}