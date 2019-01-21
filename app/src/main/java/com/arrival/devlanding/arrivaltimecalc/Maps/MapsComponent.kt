package com.arrival.devlanding.arrivaltimecalc.Maps

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules= [MapsModule::class])
interface MapsComponent{

    fun inject(app: MapsActivity)
}