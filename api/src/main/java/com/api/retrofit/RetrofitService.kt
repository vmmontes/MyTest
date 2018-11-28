package com.api.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL = "http://redirect.mytaxi.net"
    private lateinit var service: MyTaxiApiService
    private var initService = false

    fun getService(): MyTaxiApiService {
        if (!initService) {
            val httpClient = OkHttpClient.Builder().build()
            val GsonConverterFactory = GsonConverterFactory.create()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory)
                .build()

            service = retrofit.create(MyTaxiApiService::class.java)

            initService = true
        }

        return service
    }
}