package com.example.openweather.ui.main.cityselectedlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.example.openweather.R
import com.example.openweather.model.CityModel
import com.example.openweather.ui.main.cityforecast.CityForecastFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.city_weather_fragment.*
import javax.inject.Inject


class SelectedCityListFragment @Inject constructor(): WolmoFragment<SelectedCityListPresenter>(), ISelectedCityListView  {

    private lateinit var cityModels: ArrayList<CityModel>



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            cityModels = it.getSerializable(CITYMODELS) as ArrayList<CityModel>
        }

        setTabLayoutData()
    }

    //override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.city_weather_fragment, container, false)!!

    override fun layout(): Int = R.layout.city_weather_fragment

    override fun init() {
        arguments?.let {
            cityModels = it.getSerializable(CITYMODELS) as ArrayList<CityModel>
        }

        setTabLayoutData()
    }

    private fun setTabLayoutData() {

        //val simpleFragmentPagerAdapter = SelectedCityListPagerAdapter(childFragmentManager,cityModels)
        val simpleFragmentPagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager)
        simpleFragmentPagerAdapter.apply {
            //addFragment(CityForecastFragment(cityModels[0]), cityModels[0].name!!)
            //addFragment(testFragment, cityModels[0].name!!)
            //addFragment(TestFragment.newInstance(requireContext(),cityModels[0]), cityModels[0].name!!)
            addFragment(CityForecastFragment(cityModels[0]), cityModels[0].name!!)



//            cityModels.forEach {
//                testFragment.cityModel = it
//                addFragment(testFragment, it.name!!)
//            }
        }

        vpCity.apply {
            adapter = simpleFragmentPagerAdapter
            //offscreenPageLimit = 1
            currentItem = 0
        }

        tlCityList.setupWithViewPager(vpCity)
        tlCityList.tabMode = TabLayout.MODE_FIXED
        tlCityList.tabGravity = TabLayout.GRAVITY_FILL
//        tlCityList.addOnTabSelectedListener(object :
//                TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
////                if (tab.text == getString(R.string.reception_downloads_in_progress)) {
////                    vReceptionDownloadsFloatingActionButton.visibility = View.GONE
////                } else
////                    vReceptionDownloadsFloatingActionButton.visibility = View.VISIBLE
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab) {
//            }
//        })

        //hideLoading()
    }

//    override fun renderItemList(classificationState: ClassificationState) {
//        isMenuLoaded = true
//        toggleLoadingSpinner()
//    }
//
//    private fun toggleLoadingSpinner() {
//        if (isProgressListLoaded && isPendingListLoaded && isMenuLoaded) {
//            hideLoading()
//        }
//    }



    override fun hideLoading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance(context: Context, cityModels: ArrayList<CityModel>): SelectedCityListFragment {
            return Fragment.instantiate(context, SelectedCityListFragment::class.java.name, Bundle().apply { putSerializable(CITYMODELS, cityModels) }) as SelectedCityListFragment
        }
        const val CITYMODELS = "citymodels"

    }
}
