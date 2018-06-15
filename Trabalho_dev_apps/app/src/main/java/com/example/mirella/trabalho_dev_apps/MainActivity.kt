package com.example.mirella.trabalho_dev_apps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Comunicador {

    lateinit var newBook: Book

    override fun responde(book: Book) {
        newBook = book
    }

    private val viewPageAdapter: ScreenSlidePagerAdapter by lazy { ScreenSlidePagerAdapter(supportFragmentManager) }
    private val gridSlidePageFragment: GridSlidePageFragment by lazy { viewPageAdapter.getItem(ScreenSlidePagerAdapter.GRID_SLID) as GridSlidePageFragment }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = viewPageAdapter
        pager.isDrawingCacheEnabled = false

        configureOnPageChange()
    }

    private fun configureOnPageChange() {
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    ScreenSlidePagerAdapter.GRID_SLID -> {
                        gridSlidePageFragment.notificarAdapter(newBook)
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }
}
