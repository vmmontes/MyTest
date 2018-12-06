package com.vmmontes.mytest.data.dataSource

import com.vmmontes.mytest.domain.model.VehicleDomainModel

interface VehicleDataSourceContract {
    fun getVehicles(): List<VehicleDomainModel>
}