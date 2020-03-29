package com.example.openweather.ui.main.cityselectedlist


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

import com.example.openweather.model.CityModel
import java.util.ArrayList
import javax.inject.Inject


class SelectedCityListPagerAdapter(fm: FragmentManager, var adapterList: List<CityModel>) : FragmentStatePagerAdapter(fm) {



    private var fragments = ArrayList<Fragment>()
    private var titles = ArrayList<String>()


    override fun getItem(position: Int): Fragment {
            return fragments[position]

    }

    override fun getCount(): Int {
        return adapterList.size
    }


    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }



}
