package com.example.openweather.ui.main.cityselection

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import com.example.geopagos.ui.main.amount.ICitySelectionView
import com.example.geopagos.utils.SharedPreferencesUtils
import com.example.openweather.model.CityModel
import com.example.openweather.shareable.Callback
import com.example.openweather.shareable.ComboModelSearcherDialogFragment

import javax.inject.Inject

class CitySelectionPresenter @Inject constructor() : BasePresenter<ICitySelectionView>() {
    @Inject
    internal lateinit var sharedPreferencesUtils: SharedPreferencesUtils


    fun setFilter(tv: TextView, fragmentManager: FragmentManager){
        val combo =
            ComboModelSearcherDialogFragment().newInstance(sharedPreferencesUtils.cityList!!, "Ciudad", object :
                Callback {
                override fun onResponseOk(vararg objs: Any) {
                    val cityModel = objs[0] as CityModel
                    view.renderCityResponse(cityModel,tv)
                }

                override fun onResponseError(vararg objs: Any) {}
            })
        combo.show(fragmentManager, "dialog")
    }

    fun checkCityCompleted(c1: String?,c2: String?,c3: String?,c4: String?,c5: String?){
        if(!c1.isNullOrEmpty()||!c2.isNullOrEmpty()||!c3.isNullOrEmpty()||!c4.isNullOrEmpty()||!c5.isNullOrEmpty())

        else
            view.showError("Se debe seleccionar al menos una ciudad.")
    }
}
