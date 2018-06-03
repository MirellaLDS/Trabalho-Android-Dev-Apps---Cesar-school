package com.example.mirella.trabalho_dev_apps

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

class RecyclerViewAdapter (var data: List<Report>): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var ctx: Context? = null

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
        holder.image.setImageDrawable(data[position].image)
        ctx?.let {
            holder.image.setOnClickListener{
                Toast.makeText(ctx, "Click $position", Toast.LENGTH_LONG).show()
//                val intent = Intent(ctx, DetailActivity::class.java)
//                startActivity()
            }
        }
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val image = itemView!!.findViewById<ImageView>(R.id.image_view)

    }

}