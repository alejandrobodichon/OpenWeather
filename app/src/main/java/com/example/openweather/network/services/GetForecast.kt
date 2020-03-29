package com.example.openweather.network.services


import com.example.openweather.model.ResponseForecastModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetForecast {

    @GET("/data/2.5/forecast/")
    fun getForecast(
        @Query("id") cityId: String,
        @Query("units") units: String,
        @Query("appid") appId: String,
        @Query("lang") lang: String
    ): Call<ResponseForecastModel>
}