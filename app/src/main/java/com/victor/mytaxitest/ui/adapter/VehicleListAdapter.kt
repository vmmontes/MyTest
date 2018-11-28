package com.victor.mytaxitest.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.victor.mytaxitest.R
import com.victor.mytaxitest.domain.model.VehicleDomainModel
import com.victor.mytaxitest.useCases.GetVehiclesUseCaseCallback
import kotlinx.android.synthetic.main.vehicles_item_list.view.*


class VehicleListAdapter(private var vehicles: List<VehicleDomainModel>) : RecyclerView.Adapter<VehicleListAdapter.ViewHolder>() {

    lateinit var onClckVehicleListListener : ClickVehicleList

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val imgTopLeftTopTaxi = view.TopTaxiImgStart
        val imgTopRightTopTaxi = view.TopTaxiImgEnd
        val address = view.addressTxt
        val vehicleName = view.nameTxt
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): VehicleListAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.vehicles_item_list, parent, false)

        return ViewHolder(view)
    }

    fun setVehicles(vehicles: List<VehicleDomainModel>) {
        this.vehicles = vehicles
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehicle = vehicles[position]

        if (isPairNumber(position)) {
            holder.imgTopLeftTopTaxi.visibility = View.GONE
            holder.imgTopRightTopTaxi.visibility = View.VISIBLE
            alignTexts(holder, RelativeLayout.ALIGN_PARENT_LEFT)
        } else {
            holder.imgTopLeftTopTaxi.visibility = View.VISIBLE
            holder.imgTopRightTopTaxi.visibility = View.GONE
            alignTexts(holder, RelativeLayout.ALIGN_PARENT_RIGHT)
        }

        holder.vehicleName.text = vehicle.name
        holder.address.text = vehicle.address

        holder.view.setOnClickListener{
            onClckVehicleListListener.onClick(vehicle)
        }
    }

    private fun isPairNumber(number : Int) : Boolean = (number.rem(2) == 0)

    private fun alignTexts(holder: ViewHolder, position : Int) {
        changePositionView(holder.address, position)
        changePositionView(holder.vehicleName, position)
    }

    private fun changePositionView(view : View, align : Int) {
        val params = view.getLayoutParams() as RelativeLayout.LayoutParams
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0)
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0)
        params.addRule(align)

        view.setLayoutParams(params)
    }

    override fun getItemCount() = vehicles.size

    fun addClickCallback(callback: ClickVehicleList) {
        this.onClckVehicleListListener = callback
    }

    interface ClickVehicleList {
        fun onClick(vehicle : VehicleDomainModel)
    }
}