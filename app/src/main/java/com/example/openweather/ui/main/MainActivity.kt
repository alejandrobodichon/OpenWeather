package com.example.openweather.ui.main

import android.view.View
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import com.example.geopagos.utils.SharedPreferencesUtils
import com.example.openweather.R
import com.example.openweather.model.CityModel
import com.example.openweather.ui.main.cityselection.CitySelectionFragment
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject


class MainActivity : WolmoActivity() {

    @Inject internal lateinit var sharedPreferencesUtils: SharedPreferencesUtils

    override fun init() {
        saveCityData()
        replaceFragment(R.id.vContainer,CitySelectionFragment())
    }

    override fun layout()= R.layout.activity_main

    private fun saveCityData(){

        try {
            val inputStream: InputStream = this.assets.open("city.list.json")
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            val json = String(bytes)
            val listType = object : TypeToken<List<CityModel>>() {}.type
            val cityList : List<CityModel> = Gson().fromJson(json, listType)
            sharedPreferencesUtils.cityList = cityList

        } catch (ex: IOException) {
            ex.printStackTrace().toString()
        }
    }

    fun showSnackBar(parent: View, message: String) {
        Snackbar.make(parent, message, Snackbar.LENGTH_LONG).show()
    }
}
