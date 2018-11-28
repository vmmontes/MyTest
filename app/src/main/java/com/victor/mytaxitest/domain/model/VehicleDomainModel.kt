package com.victor.mytaxitest.domain.model

import java.io.Serializable


data class VehicleDomainModel(
    val address: String,
    val coordinates: List<Double>,
    val name: String,
    val vin: String,
    val fuel: Int
) : Serializable