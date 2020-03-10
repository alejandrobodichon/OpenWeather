package com.example.geopagos.utils

import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import ar.com.wolox.wolmo.core.util.SharedPreferencesManager
import com.example.openweather.model.CityModel
import com.example.openweather.model.CityModelList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import javax.inject.Inject

@ApplicationScope
class SharedPreferencesUtils @Inject constructor(
    private val sharedPreferencesManager: SharedPreferencesManager
) {

    private val gson: Gson = Gson()

    var cityList: List<CityModel>?
        get() {
            val fieldJson = sharedPreferencesManager.get(KEY_CITY, null)
            val listType = object : TypeToken<List<CityModel>>() {}.type
            return gson.fromJson(fieldJson,listType)
        }
        set(cityList) {
            sharedPreferencesManager.store(KEY_CITY, gson.toJson(cityList))
        }




    companion object {
        private const val KEY_CITY = "key_city"
    }
}
