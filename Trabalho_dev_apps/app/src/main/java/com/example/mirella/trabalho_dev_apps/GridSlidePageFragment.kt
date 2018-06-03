package com.example.mirella.trabalho_dev_apps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class GridSlidePageFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(
                R.layout.fragment_grid_view_slide_page, container, false) as ViewGroup

        val report1 = Book("Title", "Description", R.drawable.capa_toda_poesia)
        val report2 = Book("Title", "Description", R.drawable.culpa_e_das_estrelas)
        val report3 = Book("Title", "Description", R.drawable.enigma_do_principe)
        val report4 = Book("Title", "Description", R.drawable.o_pequeno_principe)

        val list = listOf(report1, report2, report3, report4)

        val adapter = CardViewAdapter(list)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recycler_view_id)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        return rootView
    }
}