package com.arrival.devlanding.arrivaltimecalc.Maps

import com.arrival.devlanding.arrivaltimecalc.RepositoryModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules= [MapsModule::class, RepositoryModule::class])
interface MapsComponent{

    fun inject(app: MapsActivity)
}