package com.example.openweather.ui.main.cityselection

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import com.example.openweather.model.CityModel
import com.example.openweather.shareable.Callback
import com.example.openweather.shareable.ComboModelSearcherDialogFragment
import com.example.openweather.utils.SharedPreferencesUtils

import javax.inject.Inject

class CitySelectionPresenter @Inject constructor() : BasePresenter<ICitySelectionView>() {
    @Inject
    internal lateinit var sharedPreferencesUtils: SharedPreferencesUtils


    fun setFilter(tv: TextView, fragmentManager: FragmentManager) {
        view?.showProgressBar()
        val combo =
            ComboModelSearcherDialogFragment().newInstance(
                sharedPreferencesUtils.cityList!!,
                "Ciudad",
                object :
                    Callback {
                    override fun onResponseOk(vararg objs: Any) {
                        val cityModel = objs[0] as CityModel
                        view?.renderCityResponse(cityModel, tv)
                        view?.hideProgressBar()
                    }

                    override fun onResponseError(vararg objs: Any) {
                        view?.hideProgressBar()
                    }
                })
        combo.show(fragmentManager, "dialog")
    }

    fun checkCityCompleted(cityModel: CityModel?) {
        if (!cityModel?.id.isNullOrEmpty()){
            view?.goToForecastFragment(cityModel!!)
        }
        else
            view?.showError("Se debe seleccionar una ciudad.")
    }
}
