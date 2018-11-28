package com.victor.mytaxitest.ui.vehicleList

import com.victor.mytaxitest.ui.core.MyTaxiTestActivity

class VehicleListActivity : MyTaxiTestActivity(){

    override fun onRequestFragment() = VehicleListFragment.newInstance()
}
