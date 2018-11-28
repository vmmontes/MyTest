package com.api.retrofit

import com.api.model.VehicleResponseApiModel
import retrofit2.Call
import retrofit2.http.GET

interface MyTaxiApiService {

    @GET("car2go/vehicles.json")
    fun getVehicles(): Call<VehicleResponseApiModel>
}