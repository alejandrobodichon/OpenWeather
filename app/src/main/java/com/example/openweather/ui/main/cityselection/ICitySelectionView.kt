package com.example.openweather.ui.main.cityselection

import android.telephony.SmsMessage
import android.widget.TextView
import com.example.openweather.model.CityModel


interface ICitySelectionView {

    fun renderCityResponse(cityModel: CityModel,tv: TextView)
    fun showError(message: String)
    fun hideProgressBar()
    fun showProgressBar()
    fun goToForecastFragment(cityModel: CityModel)
}
