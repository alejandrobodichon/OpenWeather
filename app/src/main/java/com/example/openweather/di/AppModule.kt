package com.example.openweather.di


import com.example.openweather.ui.main.MainActivity
import com.example.openweather.ui.main.cityforecast.CityForecastFragment
import com.example.openweather.ui.main.cityselectedlist.SelectedCityListFragment
import com.example.openweather.ui.main.cityselection.CitySelectionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {


    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun citySelectionFragment(): CitySelectionFragment

    @ContributesAndroidInjector
    internal abstract fun cityForecastFragment(): CityForecastFragment

    @ContributesAndroidInjector
    internal abstract fun selectedCityListFragment(): SelectedCityListFragment

}