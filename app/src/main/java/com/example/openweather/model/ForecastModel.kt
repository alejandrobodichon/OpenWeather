package com.example.openweather.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ForecastModel(@SerializedName("main") val main: MainModel,
                         @SerializedName("weather") val weather: List<WeatherModel>
) : Serializable