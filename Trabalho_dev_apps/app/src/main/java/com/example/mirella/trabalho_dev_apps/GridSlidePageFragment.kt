package com.example.mirella.trabalho_dev_apps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_grid_view_slide_page.*

class GridSlidePageFragment: Fragment() {

    private val list: MutableList<Book> = mutableListOf(Book("Title", "Description", R.drawable.capa_toda_poesia),
            Book("Title", "Description", R.drawable.culpa_e_das_estrelas),
            Book("Title", "Description", R.drawable.enigma_do_principe),
            Book("Title", "Description", R.drawable.o_pequeno_principe))

    private val adapter = CardViewAdapter(list)
    private lateinit var activity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(
                R.layout.fragment_grid_view_slide_page, container, false) as ViewGroup

        val adapter = CardViewAdapter(list)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recycler_view_id)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        return rootView
    }

    fun notificarAdapter(book: Book) {
//        if (!list.contains(book)) {
            list.add(0,book)
            adapter.notifyItemInserted(0)
//        }
    }
}