package com.vmmontes.mytest.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.vmmontes.mytest.R
import com.vmmontes.mytest.domain.model.VehicleDomainModel
import com.vmmontes.mytest.utils.isPairNumber
import kotlinx.android.synthetic.main.vehicles_item_list_left.view.*


class VehicleListAdapter(private var vehicles: List<VehicleDomainModel>) : RecyclerView.Adapter<VehicleListAdapter.ViewHolder>() {
    val VIEW_TYPE_LEFT = 0
    val VIEW_TYPE_RIGHT = 1

    lateinit var onClckVehicleListListener : ClickVehicleList

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val address = view.addressTxt
        val vehicleName = view.nameTxt
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): VehicleListAdapter.ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.vehicles_item_list_right, parent, false)

        if (viewType == VIEW_TYPE_LEFT) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.vehicles_item_list_left, parent, false)
        }

        return ViewHolder(view)
    }

    fun setVehicles(vehicles: List<VehicleDomainModel>) {
        this.vehicles = vehicles
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehicle = vehicles[position]

        holder.vehicleName.text = vehicle.name
        holder.address.text = vehicle.address

        holder.view.setOnClickListener{
            onClckVehicleListListener.onClick(vehicle)
        }
    }

    override fun getItemViewType(position: Int): Int {
        var viewType = VIEW_TYPE_RIGHT
        if (isPairNumber(position)) {
            viewType = VIEW_TYPE_LEFT
        }

        return viewType
    }

    override fun getItemCount() = vehicles.size

    fun addClickCallback(callback: ClickVehicleList) {
        this.onClckVehicleListListener = callback
    }

    interface ClickVehicleList {
        fun onClick(vehicle : VehicleDomainModel)
    }


}