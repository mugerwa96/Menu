package com.mugerwa.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val list = intent.getParcelableExtra<Food>("list")
        if (list != null) {
            val title:TextView=findViewById(R.id.detailedtitle)
            val image:ImageView=findViewById(R.id.detailimage)
            val dsc:TextView=findViewById(R.id.detaileddesc)
                title.text=list.title
                image.setImageResource(list.image)
                dsc.text=list.desc
        }
    }
}