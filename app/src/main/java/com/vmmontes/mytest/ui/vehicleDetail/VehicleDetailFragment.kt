package com.vmmontes.mytest.ui.vehicleDetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vmmontes.mytest.R
import com.vmmontes.mytest.domain.model.VehicleDomainModel
import com.vmmontes.mytest.presentation.presenter.vechileDetail.VehicleDetailPresenter
import com.vmmontes.mytest.ui.common.VEHICLE_DETAIL_TAG
import kotlinx.android.synthetic.main.vehicles_detail_fragment.*


class VehicleDetailFragment : Fragment(), VehicleDetailContract, MapManager.MapReady {
    private var presenter: VehicleDetailPresenter = VehicleDetailPresenter()
    private lateinit var mapManager: MapManager

    companion object {
        fun newInstance(vehicle: VehicleDomainModel) : VehicleDetailFragment {
            val args = Bundle()
            args.putSerializable(VEHICLE_DETAIL_TAG, vehicle)
            val fragment = VehicleDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.vehicles_detail_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var vehicle : VehicleDomainModel
        if (arguments != null) {
            vehicle = arguments?.getSerializable(VEHICLE_DETAIL_TAG) as VehicleDomainModel
        }

        presenter.onAttach(this, vehicle)
        mapManager = MapManager(mapViewVehicles)
        mapManager.OnCreate(savedInstanceState, this)

        detailVehicleBottomSheet.setValues(vehicle)
        floatingActionButton.setOnClickListener {
            if (detailVehicleBottomSheet.lastDirection == DetailVehicleBottomSheet.Direction.BOTTOM) {
                detailVehicleBottomSheet.startBottomToTopAnimation()
                floatingActionButton.setImageResource(R.drawable.ic_down_arrow)
            } else {
                detailVehicleBottomSheet.startTopToBottomAnimation()
                floatingActionButton.setImageResource(R.drawable.ic_up_arrow)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mapManager.onResume()
        presenter.onViewReady()
    }

    override fun onStart() {
        super.onStart()
        mapManager.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapManager.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapManager.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapManager.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapManager.onLowMemory()
    }

    override fun mapIsReady() {
        presenter.mapIsReady()
    }

    override fun addVehicleIntoMap(vehicle: VehicleDomainModel) {
        mapManager.addMarker(vehicle.coordinates.get(1), vehicle.coordinates.get(0))
    }
}
