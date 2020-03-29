package com.example.openweather.network.services


import com.example.openweather.model.ForecastModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetWeather {

    @GET("/data/2.5/weather/")
    fun getWeather(
        @Query("id") cityId: String,
        @Query("units") units: String,
        @Query("appid") appId: String,
        @Query("lang") lang: String
    ): Call<ForecastModel>
}