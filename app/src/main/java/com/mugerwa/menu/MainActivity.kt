package com.mugerwa.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var images= arrayListOf<Int>(
                R.drawable.coffee_pot,
                R.drawable.espresso,
                R.drawable.french_fries,
                R.drawable.honey
        )

        var title= arrayListOf<String>(
            "COFFEE",
            "PRESSO",
            "FRENCH FRIES",
            "HONEY"
        )

         var des= arrayListOf<String>(
             "Coffee is a beverage brewed from the roasted and ground seeds of the tropical evergreen coffee plant. Coffee is one of the three most popular beverages in the world (alongside water and tea), and it is one of the most profitable international commodities.",
             "Food is any substance consumed to provide nutritional support for an organism. Food is usually of plant, animal, or fungal origin, and contains essential nutrients, such as carbohydrates, fats, proteins, vitamins, or minerals.",
             "French cuisine (French: Cuisine française) consists of the cooking traditions and practices from France. Its cuisine has been influenced throughout the centuries by the many surrounding cultures of Spain, Italy, Switzerland, Germany and Belgium, in addition to its own food traditions on the long western coastlines of the Atlantic, the Channel and inland.",
             "Honey is essentially pure sugar, with no fat and only trace amounts of protein and fiber. It contains small amounts of some nutrients, but most people typically don't consume enough honey for it to be a significant dietary source of vitamins and minerals.\n"
         )

        var data= mutableListOf<Food>()

        for(i in images.indices)
        {
            data.add(Food(title[i],des[i],images[i]))
        }

//        my adapter

        var myAdapter=FoodAdapter(data)
        val recycler:RecyclerView=findViewById(R.id.recycler)
        recycler.layoutManager=GridLayoutManager(this,2)
        recycler.adapter=myAdapter
        myAdapter.onItemClick={
            val intent= Intent(this,FoodDetails::class.java)
            intent.putExtra("list",it)
            startActivity(intent)
        }
    }
}