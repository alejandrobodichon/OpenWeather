package com.example.openweather.ui.main.cityselection

import android.view.View
import android.widget.TextView
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import com.example.openweather.R
import com.example.openweather.model.CityModel
import com.example.openweather.ui.main.MainActivity
import com.example.openweather.ui.main.cityforecast.CityForecastFragment
import com.example.openweather.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject


class CitySelectionFragment : WolmoFragment<CitySelectionPresenter>(), ICitySelectionView {

    private var citySelected1: CityModel? = null
    private var citySelected2: CityModel? = null
    private var citySelected3: CityModel? = null
    private var citySelected4: CityModel? = null
    private var citySelected5: CityModel? = null

    @Inject internal lateinit var sharedPreferencesUtils: SharedPreferencesUtils

    override fun layout(): Int = R.layout.fragment_main

    override fun init() {
        setSavedCities()

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

        ivArrow1.setOnClickListener {
            presenter.checkCityCompleted(citySelected1)
        }

        ivArrow2.setOnClickListener {
            presenter.checkCityCompleted(citySelected2)
        }

        ivArrow3.setOnClickListener {
            presenter.checkCityCompleted(citySelected3)
        }

        ivArrow4.setOnClickListener {
            presenter.checkCityCompleted(citySelected4)
        }

        ivArrow5.setOnClickListener {
            presenter.checkCityCompleted(citySelected5)
        }
    }


    private fun setSavedCities(){
        sharedPreferencesUtils.cityModel1?.let {
            tvCity1.text = sharedPreferencesUtils.cityModel1!!.name
            citySelected1 = sharedPreferencesUtils.cityModel1
        }

        sharedPreferencesUtils.cityModel2?.let {
            tvCity2.text = sharedPreferencesUtils.cityModel2!!.name
            citySelected2 = sharedPreferencesUtils.cityModel2
        }

        sharedPreferencesUtils.cityModel3?.let {
            tvCity3.text = sharedPreferencesUtils.cityModel3!!.name
            citySelected3 = sharedPreferencesUtils.cityModel3
        }

        sharedPreferencesUtils.cityModel4?.let {
            tvCity4.text = sharedPreferencesUtils.cityModel4!!.name
            citySelected4 = sharedPreferencesUtils.cityModel4
        }

        sharedPreferencesUtils.cityModel5?.let {
            tvCity5.text = sharedPreferencesUtils.cityModel5!!.name
            citySelected5 = sharedPreferencesUtils.cityModel5
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = "Pronóstico"
    }

    override fun renderCityResponse(cityModel: CityModel, tv: TextView) {
        tv.text = cityModel.name
        when (tv.id) {
            R.id.tvCity1 -> {
                citySelected1 = cityModel
                sharedPreferencesUtils.cityModel1 = cityModel
            }
            R.id.tvCity2 -> {
                citySelected2 = cityModel
                sharedPreferencesUtils.cityModel2 = cityModel
            }
            R.id.tvCity3 -> {
                citySelected3 = cityModel
                sharedPreferencesUtils.cityModel3 = cityModel
            }
            R.id.tvCity4 -> {
                citySelected4 = cityModel
                sharedPreferencesUtils.cityModel4 = cityModel
            }
            R.id.tvCity5 -> {
                citySelected5 = cityModel
                sharedPreferencesUtils.cityModel5 = cityModel
            }
        }

    }

    override fun goToForecastFragment(cityModel: CityModel) {
        (requireActivity() as MainActivity).replaceFragment(
            CityForecastFragment(cityModel),R.id.vBaseContent,true,
            cityModel.name+ ", " + cityModel.country,false)
    }

    override fun showError(message: String) {
        ToastFactory(requireContext()).show(message)
    }

    override fun hideProgressBar(){
        clProgressBar.visibility = View.GONE
    }

    override fun showProgressBar(){
        clProgressBar.visibility = View.VISIBLE
    }

}