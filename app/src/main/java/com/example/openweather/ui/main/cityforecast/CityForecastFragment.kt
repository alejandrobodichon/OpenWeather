package com.example.openweather.ui.main.cityforecast

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import com.example.openweather.R
import com.example.openweather.model.CityModel
import com.example.openweather.model.ForecastModel
import com.example.openweather.ui.main.MainActivity
import com.example.openweather.ui.main.cityselection.CityForecastPresenter
import com.example.openweather.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.fragment_forecast.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject


class CityForecastFragment @Inject constructor(private val cityModel: CityModel): WolmoFragment<CityForecastPresenter>(), ICityForecastView {

    @Inject internal lateinit var sharedPreferencesUtils: SharedPreferencesUtils
    @Inject internal lateinit var toastFactory: ToastFactory

    override fun layout(): Int = R.layout.fragment_forecast

    override fun init() {
        presenter.getData(cityModel)
    }

    override fun renderWeatherResponse(forecastModel: ForecastModel) {
        tvWeatherTemperature1.text = forecastModel.main.temp + " °C"
        tvWeatherTemperatureMin.text = forecastModel.main.minTemp + " °C"
        tvWeatherTemperatureMax.text = forecastModel.main.maxTemp + " °C"
        vWeatherPicture1.setImageURI("http://openweathermap.org/img/wn/"+ forecastModel.weather[0].icon +"@2x.png")
    }

    override fun renderCityResponse(forecastModels: List<ForecastModel>) {
        tvForecastTemperature1.text = forecastModels[0].main.temp + " °C"
        vForecastPicture1.setImageURI("http://openweathermap.org/img/wn/"+ forecastModels[0].weather[0].icon +"@2x.png")

        tvForecastTemperature2.text = forecastModels[1].main.temp + " °C"
        vForecastPicture2.setImageURI("http://openweathermap.org/img/wn/"+ forecastModels[1].weather[0].icon +"@2x.png")

        tvForecastTemperature3.text = forecastModels[2].main.temp + " °C"
        vForecastPicture3.setImageURI("http://openweathermap.org/img/wn/"+ forecastModels[2].weather[0].icon +"@2x.png")

        tvForecastTemperature4.text = forecastModels[3].main.temp + " °C"
        vForecastPicture4.setImageURI("http://openweathermap.org/img/wn/"+ forecastModels[3].weather[0].icon +"@2x.png")

        tvForecastTemperature5.text = forecastModels[4].main.temp + " °C"
        vForecastPicture5.setImageURI("http://openweathermap.org/img/wn/"+ forecastModels[4].weather[0].icon +"@2x.png")
    }

    override fun showError(message: String) {
        (requireActivity() as MainActivity).showSnackBar(view!!.rootView,message)
    }

    override fun hideProgressBar(){
        clProgressBar.visibility = View.GONE
    }

    override fun showProgressBar(){
        clProgressBar.visibility = View.VISIBLE
    }



}