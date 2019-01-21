package com.arrival.devlanding.arrivaltimecalc.Maps

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapsModule(val activity: MapsActivity) {

    @Provides
    @Singleton
    fun providesMapsPresenter(): MapsContract.presenter {
        return MapsPresenter(activity)
    }

}