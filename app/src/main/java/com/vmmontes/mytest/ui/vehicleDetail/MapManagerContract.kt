package com.vmmontes.mytest.ui.vehicleDetail

import android.os.Bundle

interface MapManagerContract {

    fun OnCreate(savedInstanceState: Bundle?, listener : MapManager.MapReady)
    fun onResume()
    fun onStart()
    fun onStop()
    fun onPause()
    fun onDestroy()
    fun onLowMemory()
    fun cleanMarkers()
    fun addMarker(lat : Double, long : Double)
}