package com.vmmontes.mytest.ui.vehicleDetail

import com.vmmontes.mytest.domain.model.VehicleDomainModel
import com.vmmontes.mytest.ui.core.MyTaxiTestActivity

class VehicleDetailActivity : MyTaxiTestActivity(){

    override fun onRequestFragment() = VehicleDetailFragment.newInstance(intent.extras.get("vehicle") as VehicleDomainModel)
}
