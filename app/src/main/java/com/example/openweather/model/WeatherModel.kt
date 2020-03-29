package com.example.openweather.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherModel(@SerializedName("icon") val icon: String
) : Serializable