package com.arrival.devlanding.arrivaltimecalc.Maps

import com.arrival.devlanding.arrivaltimecalc.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapsModule(val activity: MapsActivity) {

    @Provides
    @Singleton
    fun providesMapsPresenter(repository: Repository): MapsContract.presenter {
        return MapsPresenter(activity, repository)
    }

}