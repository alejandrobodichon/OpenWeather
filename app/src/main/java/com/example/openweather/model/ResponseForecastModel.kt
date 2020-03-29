package com.example.openweather.model

import java.io.Serializable

data class ResponseForecastModel(val list: List<ForecastModel>?)
    :Serializable
