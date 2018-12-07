package com.vmmontes.mytest.data

import com.api.retrofit.MyTaxiApiClient
import com.vmmontes.mytest.data.dataSource.VehicleDataSourceContract
import com.vmmontes.mytest.data.dataSource.VehiclesDataSource
import com.vmmontes.mytest.domain.model.VehicleDomainModel

class VehiclesRepositoryImp {

    val vehicleDataSource : VehicleDataSourceContract = VehiclesDataSource(MyTaxiApiClient())

    fun getVehicles(): List<VehicleDomainModel> = vehicleDataSource.getVehicles()

}