package com.example.openweather.shareable

import com.example.openweather.model.CityModel
import com.example.openweather.model.ComboModel

interface OnComboModelClick {
    fun onClick(comboModel: CityModel)
}