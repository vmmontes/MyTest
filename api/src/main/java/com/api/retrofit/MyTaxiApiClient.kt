package com.api.retrofit

import com.api.MyTaxpiApiContract
import com.api.model.VehicleApiModel

class MyTaxiApiClient: MyTaxpiApiContract{

    override fun getVehicles(): List<VehicleApiModel> {
        val response = RetrofitService.getService().getVehicles().execute()
        var placemarks = listOf<VehicleApiModel>()

        if (response.isSuccessful) {
            placemarks = response.body()!!.placemarks

        }

        return placemarks
    }
}