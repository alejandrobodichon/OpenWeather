package com.example.geopagos.ui.main.amount

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.example.geopagos.model.PaymentMethodModel
import com.example.geopagos.network.callback.AuthCallback
import com.example.geopagos.network.services.GetPaymentMethodsList
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class CitySelectionPresenter @Inject constructor() : BasePresenter<IAmountView>() {

    fun onAmountValidation(amount: Float) {
        if(amount > 0)
            view.goToPaymentMethodFragment(amount)
        else
            view.showError()
    }
}
