package com.vmmontes.mytest.ui.vehicleList

import com.vmmontes.mytest.ui.core.MyTaxiTestActivity

class VehicleListActivity : MyTaxiTestActivity(){

    override fun onRequestFragment() = VehicleListFragment.newInstance()
}
