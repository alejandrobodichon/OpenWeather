package com.example.geopagos.ui.main.amount

import com.example.geopagos.model.PaymentMethodModel


interface ICitySelectionView {

    fun showError()

    fun goToPaymentMethodFragment(amount: Float)

}
