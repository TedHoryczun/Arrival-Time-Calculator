package com.arrival.devlanding.arrivaltimecalc.Maps

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import com.arrival.devlanding.arrivaltimecalc.R
import com.arrival.devlanding.arrivaltimecalc.isPermissionGranted
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
    MapsContract.view {

    private lateinit var mMap: GoogleMap
    lateinit var fusedLocationClient: FusedLocationProviderClient
    private val LOCATION_REQUEST_CODE = 0

    @Inject
    lateinit var presenter: MapsContract.presenter

    val placeFragment: PlaceAutocompleteFragment by lazy {
        fragmentManager
            .findFragmentById(R.id.placesAutoCompleteFragment) as PlaceAutocompleteFragment
    }
    val mapFragment: SupportMapFragment by lazy {
        supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        DaggerMapsComponent.builder()
            .mapsModule(MapsModule(this)).build().inject(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mapFragment.getMapAsync(this)
        presenter.init()
        if (isPermissionGranted(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    println("here is my location: ${location}")
                }
        } else {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_REQUEST_CODE)
        }


    }

    override fun bindListeners() {
        placeFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(p0: Place?) {
                Log.i("Place Selected", p0?.name.toString())
            }

            override fun onError(p0: Status?) {
                Log.e("PlaceFragmentError", p0.toString())
            }

        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
