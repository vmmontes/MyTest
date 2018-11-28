package com.api

import com.api.model.VehicleApiModel

interface MyTaxpiApiContract {

    fun getVehicles(): List<VehicleApiModel>
}