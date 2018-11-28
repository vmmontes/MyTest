package com.victor.mytaxitest.ui.core

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.victor.mytaxitest.R

abstract class MyTaxiTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_taxi_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.myTaxiContainer, onRequestFragment(), onRequestFragment()::class.java.name).commit()
        }
    }

    abstract fun onRequestFragment(): Fragment

}
