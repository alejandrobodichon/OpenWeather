package com.example.openweather.di


import com.example.openweather.ui.main.MainActivity
import com.example.openweather.ui.main.cityselection.CitySelectionFragment
import com.example.openweather.ui.root.RootActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun rootActivity(): RootActivity

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun citySelectionFragment(): CitySelectionFragment


}