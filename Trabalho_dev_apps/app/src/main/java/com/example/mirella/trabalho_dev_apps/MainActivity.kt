package com.example.mirella.trabalho_dev_apps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mPager = findViewById<ViewPager>(R.id.pager)
        var mPagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager.adapter = mPagerAdapter
    }
}
