package com.arrival.devlanding.arrivaltimecalc.Maps

import com.arrival.devlanding.arrivaltimecalc.MapConstants
import com.arrival.devlanding.arrivaltimecalc.MapConstants.LOCATION_REQUEST_CODE
import com.arrival.devlanding.arrivaltimecalc.Repository


class MapsPresenter(val view: MapsContract.view, val repository: Repository) :
    MapsContract.presenter {
    override fun showCurrentLocation() {
        repository.getCurrentLocation()
            .subscribe { location -> view.showLocation(location) }
    }

    override fun init() {

        view.bindListeners()
    }

    override fun onRequestPermissionResult(requestCode: Int, permissions: Array<out String>) {
        when (requestCode) {
            LOCATION_REQUEST_CODE -> println("Location location")
        }
    }

}
