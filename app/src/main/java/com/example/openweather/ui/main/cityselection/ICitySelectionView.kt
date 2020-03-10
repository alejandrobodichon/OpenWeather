package com.example.geopagos.ui.main.amount

import android.telephony.SmsMessage
import android.widget.TextView
import com.example.openweather.model.CityModel


interface ICitySelectionView {

    fun renderCityResponse(cityModel: CityModel,tv: TextView)
    fun showError(message: String)


}
