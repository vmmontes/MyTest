package com.vmmontes.mytest.dataSource.mapper

import com.api.model.VehicleApiModel
import com.vmmontes.mytest.domain.model.VehicleDomainModel

fun toDomain(source: VehicleApiModel) = VehicleDomainModel(
        source.address,
        source.coordinates,
        source.name,
        source.vin,
        source.fuel
)