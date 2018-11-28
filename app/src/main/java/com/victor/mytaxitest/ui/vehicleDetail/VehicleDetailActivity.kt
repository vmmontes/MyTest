package com.victor.mytaxitest.ui.vehicleDetail

import com.victor.mytaxitest.domain.model.VehicleDomainModel
import com.victor.mytaxitest.ui.core.MyTaxiTestActivity

class VehicleDetailActivity : MyTaxiTestActivity(){

    override fun onRequestFragment() = VehicleDetailFragment.newInstance(intent.extras.get("vehicle") as VehicleDomainModel)
}
