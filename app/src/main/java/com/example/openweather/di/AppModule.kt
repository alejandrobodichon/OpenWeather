package com.example.geopagos.di

import com.example.geopagos.ui.main.MainActivity
import com.example.geopagos.ui.main.amount.AmountFragment
import com.example.geopagos.ui.main.cardissuer.CardIssuerFragment
import com.example.geopagos.ui.main.installments.InstallmentFragment
import com.example.geopagos.ui.main.paymentmethod.PaymentMethodFragment
import com.example.geopagos.ui.main.success.SuccessFragment
import com.example.geopagos.ui.root.RootActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun rootActivity(): RootActivity

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun amountFragment(): AmountFragment

    @ContributesAndroidInjector
    internal abstract fun paymentMehtodFragment(): PaymentMethodFragment

    @ContributesAndroidInjector
    internal abstract fun cardIssuerFragment(): CardIssuerFragment

    @ContributesAndroidInjector
    internal abstract fun installmentFragment(): InstallmentFragment

    @ContributesAndroidInjector
    internal abstract fun successFragment(): SuccessFragment

}