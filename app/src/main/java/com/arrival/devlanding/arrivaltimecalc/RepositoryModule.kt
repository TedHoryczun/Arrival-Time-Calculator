package com.arrival.devlanding.arrivaltimecalc

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule(val context: Context){

    @Provides
    fun providesRepository(): Repository {
        return Repository(context)

    }



}