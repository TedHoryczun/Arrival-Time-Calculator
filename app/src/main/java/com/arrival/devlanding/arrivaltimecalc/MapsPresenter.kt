package com.arrival.devlanding.arrivaltimecalc


class MapsPresenter(val view: MapsContract.view): MapsContract.presenter{
    override fun init() {
        view.bindListeners()
    }


}
