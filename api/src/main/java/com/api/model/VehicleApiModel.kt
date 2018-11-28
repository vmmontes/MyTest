package com.api.model

data class VehicleApiModel(
        val address: String,
        val coordinates: List<Double>,
        val name: String,
        val vin: String,
        val fuel: Int,
        val engineType: EngineType,
        val exterior: State,
        val interior: State
        ) {

    enum class State {
        REALLY_GOOD, GOOD, BAD, UNACCEPTABLE
    }

    enum class EngineType {
        CE
    }
}

