package com.vmmontes.mytest.ui.vehicleDetail

import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng



class MapManager constructor(val mapView: MapView) : MapManagerContract, OnMapReadyCallback{
    lateinit var mMap: GoogleMap
    lateinit var listener : MapReady

    override fun onMapReady(googleMap: GoogleMap?) {
        this.mMap = googleMap!!
        listener.mapIsReady()
    }

    override fun OnCreate(savedInstanceState: Bundle?, listener : MapReady) {
        this.listener = listener
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onResume() {
        mapView.onResume()
    }

    override fun onStart() {
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
    }

    override fun onPause() {
        mapView.onPause()
    }

    override fun onDestroy() {
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        mapView.onLowMemory()
    }

    override fun cleanMarkers() {
        mMap.clear()
    }

    override fun addMarker(lat : Double, long : Double) {
        val marker = LatLng(lat, long)
        mMap.addMarker(MarkerOptions().position(marker))
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(lat, long),
                14.0f
            )
        )
    }

    interface MapReady {
        fun mapIsReady()
    }
}