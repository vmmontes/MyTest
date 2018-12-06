package com.vmmontes.mytest.data.dataSource

import com.api.MyTaxpiApiContract
import com.vmmontes.mytest.data.mapper.toDomain
import com.vmmontes.mytest.domain.model.VehicleDomainModel

class VehiclesDataSource constructor(
    private val taxiApiClient: MyTaxpiApiContract) : VehicleDataSourceContract {

    override fun getVehicles(): List<VehicleDomainModel> {
        val vehiclesApiModel = taxiApiClient.getVehicles()

        val vehiclesDomainModel = mutableListOf<VehicleDomainModel>()

        for(vehicleApi in vehiclesApiModel) {
            vehiclesDomainModel.add(toDomain(vehicleApi))
        }

        return vehiclesDomainModel
    }
}