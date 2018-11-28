package com.victor.mytaxitest.dataSource.mapper

import com.api.model.VehicleApiModel
import com.victor.mytaxitest.domain.model.VehicleDomainModel

fun toDomain(source: VehicleApiModel) = VehicleDomainModel(
        source.address,
        source.coordinates,
        source.name,
        source.vin,
        source.fuel
)