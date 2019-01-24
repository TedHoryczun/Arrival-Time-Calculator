package com.arrival.devlanding.arrivaltimecalc

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.support.annotation.RequiresFeature
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Observable


class Repository(val context: Context) {

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(): Observable<CurrentLocation> {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        val ob = Observable.create<CurrentLocation> {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    location?.latitude?.let { it1 ->
                        val formattedLocation = CurrentLocation(it1, location.longitude)
                        it.onNext(formattedLocation)
                    }
                }
        }
        return ob
    }

}