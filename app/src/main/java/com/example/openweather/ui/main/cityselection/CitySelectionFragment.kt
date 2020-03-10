package com.example.openweather.ui.main.cityselection

import kotlinx.android.synthetic.main.fragment_main.*
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.example.geopagos.ui.main.amount.ICitySelectionView
import com.example.geopagos.utils.SharedPreferencesUtils
import com.example.openweather.R
import com.example.openweather.model.CityModel
import com.example.openweather.shareable.Callback
import com.example.openweather.shareable.ComboModelSearcherDialogFragment
import javax.inject.Inject


class CitySelectionFragment : WolmoFragment<CitySelectionPresenter>(), ICitySelectionView {
    @Inject
    internal lateinit var sharedPreferencesUtils: SharedPreferencesUtils

    lateinit var localidadSeleccionada1: String

    override fun layout(): Int = R.layout.fragment_main

    override fun init() {
        tvCity1.setOnClickListener {
            val combo =
                ComboModelSearcherDialogFragment().newInstance(sharedPreferencesUtils.cityList!!, "Localidad", object :
                    Callback {
                    override fun onResponseOk(vararg objs: Any) {
                        val cca = objs[0] as CityModel
                        tvCity1.text = cca.name +" - "+ cca.country
                        localidadSeleccionada1 = cca.id!!
                    }

                    override fun onResponseError(vararg objs: Any) {}
                })
            combo.show(fragmentManager!!, "dialog")

        }
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

}