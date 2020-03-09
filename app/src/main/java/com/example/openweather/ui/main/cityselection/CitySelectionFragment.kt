package com.example.openweather.ui.main.cityselection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import android.view.LayoutInflater
import android.view.ViewGroup
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.example.geopagos.ui.main.amount.CitySelectionPresenter
import com.example.geopagos.ui.main.amount.ICitySelectionView
import com.example.openweather.R


class CitySelectionFragment : WolmoFragment<CitySelectionPresenter>(),ICitySelectionView {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        initialize()
        return view

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

}