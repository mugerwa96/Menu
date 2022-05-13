package com.mugerwa.menu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class FoodAdapter(val food:List<Food>):RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    var onItemClick:((Food)->Unit)?=null
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        val title:TextView=itemView.findViewById(R.id.foodtitle)
        val image:ImageView=itemView.findViewById(R.id.foodimage)
        private lateinit var  desc:TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.foodcard,parent,false)
        return ViewHolder(view)
        

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food=food[position]
        holder.title.text=food.title
        holder.image.setImageResource(food.image)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(food)
        }
    }

    override fun getItemCount(): Int {
        return food.size
    }

}