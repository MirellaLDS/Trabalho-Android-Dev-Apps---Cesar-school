package com.example.mirella.trabalho_dev_apps

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ScreenSlidePagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private val NUM_PAGES = 5

    companion object {
        const val CAD_BOOK = 0
        const val GRID_SLID = 1
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            CAD_BOOK -> CadBookFragment()
            GRID_SLID -> GridSlidePageFragment()
            else -> ScreenSlidePageFragment()
        }
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }
}