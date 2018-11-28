package com.victor.mytaxitest.ui.vehicleDetail

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.victor.mytaxitest.R
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import kotlinx.android.synthetic.main.detail_vehicle_bottom_sheet.view.*
import android.widget.RelativeLayout
import android.animation.ValueAnimator
import com.victor.mytaxitest.domain.model.VehicleDomainModel
import com.victor.mytaxitest.ui.common.PERCENT


class DetailVehicleBottomSheet : FrameLayout{
    private var squareHeight : Int = 0
    enum class Direction {
        TOP,
        BOTTOM
    }
    var lastDirection : Direction = Direction.BOTTOM


    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    private fun initView() {
        val view = View.inflate(context, R.layout.detail_vehicle_bottom_sheet, null)
        addView(view)

        view.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                squareHeight = squareInfoDetail.height
                setSquareMarginTop(detailVehicleParent.height)
            }
        })
    }

    fun startTopToBottomAnimation() {
        initAnimation(Direction.BOTTOM)
        lastDirection = Direction.BOTTOM
    }

    fun startBottomToTopAnimation() {
        initAnimation(Direction.TOP)
        lastDirection = Direction.TOP
    }

    private fun initAnimation(direction : Direction) {
        val TIME_IN_MILISECONDS : Long = 600
        val mTimerAnimator = getTimeAnimator(direction)

        mTimerAnimator.duration = TIME_IN_MILISECONDS
        mTimerAnimator.addUpdateListener{
            val value = it.animatedValue as Int
            moveSquare(value)
        }
        mTimerAnimator.start()
    }

    private fun getTimeAnimator(direction : Direction) : ValueAnimator {
        if (direction == Direction.TOP) {
            return ValueAnimator.ofInt(detailVehicleParent.height, ((detailVehicleParent.height/2) - (squareHeight/2)))
        } else {
            return ValueAnimator.ofInt(((detailVehicleParent.height/2) - (squareHeight/2)), detailVehicleParent.height)
        }
    }

    private fun moveSquare(positionAnimator: Int) {
        setSquareMarginTop(positionAnimator)
        squareInfoDetail.invalidate()
    }

    private fun setSquareMarginTop(marginTop : Int) {
        val relativeParams = squareInfoDetail.layoutParams as RelativeLayout.LayoutParams
        relativeParams.setMargins(0, marginTop, 0, 0)
        squareInfoDetail.layoutParams = relativeParams
    }

    fun setValues(vehicle : VehicleDomainModel) {
        addressDetailTxt.text = vehicle.address
        nameDetailTxt.text = vehicle.name
        fuelTxt.text = (vehicle.fuel.toString() + PERCENT)
        vinTxt.text = vehicle.vin
    }

}
