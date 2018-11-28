package com.victor.mytaxitest.dataSource

import com.api.MyTaxpiApiContract
import com.api.retrofit.MyTaxiApiClient
import com.victor.mytaxitest.dataSource.mapper.toDomain
import com.victor.mytaxitest.domain.model.VehicleDomainModel

class ApiData {

    val taxiApiClient: MyTaxpiApiContract = MyTaxiApiClient()

    fun getVehicles(): List<VehicleDomainModel> {
        val vehiclesApiModel = taxiApiClient.getVehicles()

        val vehiclesDomainModel = mutableListOf<VehicleDomainModel>()

        for(vehicleApi in vehiclesApiModel) {
            vehiclesDomainModel.add(toDomain(vehicleApi))
        }

        return vehiclesDomainModel
    }

}