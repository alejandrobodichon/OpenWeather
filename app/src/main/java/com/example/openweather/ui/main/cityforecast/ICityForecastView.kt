package com.example.openweather.ui.main.cityforecast

import com.example.openweather.model.ForecastModel


interface ICityForecastView {

    fun showError(message: String)
    fun hideProgressBar()
    fun renderCityResponse(forecastModels: List<ForecastModel>)
    fun renderWeatherResponse(forecastModels: ForecastModel)
    fun showProgressBar()
}
