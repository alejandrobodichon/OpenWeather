package com.example.openweather.ui.main.cityselection

import kotlinx.android.synthetic.main.fragment_main.*
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.example.geopagos.ui.main.amount.CitySelectionPresenter
import com.example.geopagos.ui.main.amount.ICitySelectionView
import com.example.openweather.R


class CitySelectionFragment : WolmoFragment<CitySelectionPresenter>(),ICitySelectionView {


    override fun layout(): Int = R.layout.fragment_main

    override fun init() {

    }


    fun initialize() {
        tvCity1.setOnClickListener {
//            val combo =
//                ComboModelSearcherDialogFragment().newInstance(provinces, "Provincias", object :
//                    Callback {
//                    override fun onResponseOk(vararg objs: Any) {
//                        val cca = objs[0] as ComboModel
//                        tvCity1.text = cca.description
//                        provinciaSeleccionada = cca.value
//                    }
//
//                    override fun onResponseError(vararg objs: Any) {}
//                })
//            combo.show(fragmentManager!!, "dialog")

        }
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

}