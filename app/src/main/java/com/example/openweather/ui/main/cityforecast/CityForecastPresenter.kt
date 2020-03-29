package com.example.openweather.ui.main.cityselection

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.example.geopagos.network.callback.AuthCallback
import com.example.openweather.model.CityModel
import com.example.openweather.model.ForecastModel
import com.example.openweather.model.ResponseForecastModel
import com.example.openweather.network.services.GetForecast
import com.example.openweather.network.services.GetWeather
import com.example.openweather.ui.main.cityforecast.ICityForecastView
import com.example.openweather.utils.SharedPreferencesUtils
import com.example.openweather.utils.Utils.Companion.API_KEY
import okhttp3.ResponseBody

import javax.inject.Inject

class CityForecastPresenter @Inject constructor(private val retrofitServices: RetrofitServices) : BasePresenter<ICityForecastView>() {
    @Inject
    internal lateinit var sharedPreferencesUtils: SharedPreferencesUtils

    fun getData(cityModel: CityModel){
        view?.showProgressBar()

        getWeather(cityModel.id!!)
        getForecast(cityModel.id!!)
    }


    private fun getForecast( cityId: String) {
        retrofitServices.getService(GetForecast::class.java).getForecast(cityId,"metric"
            , API_KEY,"es"
        ).enqueue(
            object : AuthCallback<ResponseForecastModel>(this) {
                override fun onResponseSuccessful(response: ResponseForecastModel?)                     {

                    view?.renderCityResponse(response?.list!!)

                    view?.hideProgressBar()
                }

                override fun onResponseFailed(responseBody: ResponseBody?, code: Int) {
                    view?.showError("")
                    view?.hideProgressBar()
                }

                override fun onCallFailure(t: Throwable) {
                    view?.showError("")
                    view?.hideProgressBar()
                }
            })
    }

    private fun getWeather( cityId: String) {
        retrofitServices.getService(GetWeather::class.java).getWeather(cityId,"metric"
            , API_KEY,"es"
        ).enqueue(
            object : AuthCallback<ForecastModel>(this) {
                override fun onResponseSuccessful(response: ForecastModel?) {
                    view?.renderWeatherResponse(response!!)
                }

                override fun onResponseFailed(responseBody: ResponseBody?, code: Int) {
                    view?.showError("")
                }

                override fun onCallFailure(t: Throwable) {
                    view?.showError("")
                }
            })
    }
}
