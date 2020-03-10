package com.example.openweather.ui.main.cityselection

import android.widget.TextView
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.example.geopagos.ui.main.amount.ICitySelectionView
import com.example.openweather.R
import com.example.openweather.model.CityModel
import com.example.openweather.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_main.*


class CitySelectionFragment : WolmoFragment<CitySelectionPresenter>(), ICitySelectionView {

    var citySelected1: String? = null
    var citySelected2: String? = null
    var citySelected3: String? = null
    var citySelected4: String? = null
    var citySelected5: String? = null

    override fun layout(): Int = R.layout.fragment_main

    override fun init() {
        tvCity1.setOnClickListener {
            presenter.setFilter(it as TextView, requireFragmentManager())
        }
        tvCity2.setOnClickListener {
            presenter.setFilter(it as TextView, requireFragmentManager())
        }
        tvCity3.setOnClickListener {
            presenter.setFilter(it as TextView, requireFragmentManager())
        }
        tvCity4.setOnClickListener {
            presenter.setFilter(it as TextView, requireFragmentManager())
        }
        tvCity5.setOnClickListener {
            presenter.setFilter(it as TextView, requireFragmentManager())
        }
        btContinue.setOnClickListener {
            presenter.checkCityCompleted(citySelected1,citySelected2,citySelected3,citySelected4,citySelected5)
        }
    }

    override fun renderCityResponse(cityModel: CityModel, tv: TextView) {
        tv.text = cityModel.name
        when (tv.id) {
            R.id.tvCity1 -> citySelected1 = cityModel.id
            R.id.tvCity2 -> citySelected2 = cityModel.id
            R.id.tvCity3 -> citySelected3 = cityModel.id
            R.id.tvCity4 -> citySelected4 = cityModel.id
            R.id.tvCity5 -> citySelected5 = cityModel.id
        }

    }

    override fun showError(message: String) {
        (requireActivity() as MainActivity).showSnackBar(this.view!!.rootView,message)
    }

}