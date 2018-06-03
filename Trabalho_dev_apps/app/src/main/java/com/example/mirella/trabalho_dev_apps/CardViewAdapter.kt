package com.example.mirella.trabalho_dev_apps

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class CardViewAdapter (var data: List<Book>): RecyclerView.Adapter<CardViewAdapter.MyViewHolder>() {

    lateinit var ctx: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View
        ctx = parent.context
        var inflater: LayoutInflater = LayoutInflater.from(parent.context)
        view = inflater.inflate(R.layout.image_card_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(data[position].image)
        holder.cardView.setOnClickListener{ v -> onClick(v, position) }
    }

    private fun onClick(v: View?, position: Int) {
        var book: Book = data[position]
        when(v?.id) {
            R.id.cardView -> {
                val intent = Intent(ctx, DetailActivity::class.java)
                intent.putExtra("EXTRA_PEOPLE_TITLE", book.title)
                intent.putExtra("EXTRA_PEOPLE_DESCRIPTION", book.description)
                intent.putExtra("EXTRA_PEOPLE_IMAGE", book.image)
                ctx.startActivity(intent)
            }
        }
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val image = itemView!!.findViewById<ImageView>(R.id.image_view)
        val cardView = itemView!!.findViewById<CardView>(R.id.cardView)

    }

}