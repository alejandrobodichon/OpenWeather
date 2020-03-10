package com.example.openweather.ui.main.cityselection

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import com.example.geopagos.ui.main.amount.ICitySelectionView

import javax.inject.Inject

class CitySelectionPresenter @Inject constructor() : BasePresenter<ICitySelectionView>() {

    fun onAmountValidation(amount: Float) {
        if(amount > 0)
            //view.goToPaymentMethodFragment(amount)
        else
            view.showError()
    }
}
