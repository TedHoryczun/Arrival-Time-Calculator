package com.arrival.devlanding.arrivaltimecalc.Maps

import com.arrival.devlanding.arrivaltimecalc.CurrentLocation


interface MapsContract{
    interface presenter{
        fun init()
        abstract fun onRequestPermissionResult(requestCode: Int, permissions: Array<out String>)
        fun showCurrentLocation()

    }
    interface view{
        fun bindListeners()
        abstract fun showLocation(location: CurrentLocation)

    }
}