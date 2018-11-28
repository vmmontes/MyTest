package com.victor.mytaxitest.ui.vehicleList

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.mytaxitest.R
import com.victor.mytaxitest.domain.model.VehicleDomainModel
import com.victor.mytaxitest.presentation.presenter.taxisList.TaxisListPresenter
import com.victor.mytaxitest.ui.adapter.VehicleListAdapter
import com.victor.mytaxitest.ui.vehicleDetail.VehicleDetailActivity
import kotlinx.android.synthetic.main.vehicles_list_fragment.*

class VehicleListFragment : Fragment(), VehicleListContract, VehicleListAdapter.ClickVehicleList {

    private var presenter: TaxisListPresenter = TaxisListPresenter()
    private lateinit var mAdapter: VehicleListAdapter

    companion object {
        fun newInstance() = VehicleListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.vehicles_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)

        val viewManager = LinearLayoutManager(context)
        mAdapter = VehicleListAdapter(listOf())
        vehiclesList.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = mAdapter
        }

        mAdapter.addClickCallback(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewReady()
    }

    override fun showVehiclesList(vehiclesList: List<VehicleDomainModel>) {
        mAdapter.setVehicles(vehiclesList)
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun onClick(vehicle: VehicleDomainModel) {
        val intent = Intent(context, VehicleDetailActivity::class.java)
        intent.putExtra("vehicle", vehicle)
        startActivity(intent)
    }
}
