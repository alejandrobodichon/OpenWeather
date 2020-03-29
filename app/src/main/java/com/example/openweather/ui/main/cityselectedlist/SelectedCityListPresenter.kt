package com.example.openweather.ui.main.cityselectedlist

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class SelectedCityListPresenter @Inject constructor(

) : BasePresenter<ISelectedCityListView>() {

    fun tabRenderFinished() {
        view?.hideLoading()
    }
}