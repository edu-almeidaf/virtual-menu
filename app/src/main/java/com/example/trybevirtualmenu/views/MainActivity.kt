package com.example.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.DishAdapter
import com.example.trybevirtualmenu.models.DishDatabase

class MainActivity : AppCompatActivity() {
    private val dishesRV: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dishes = DishDatabase.getDishes()
        val adapter = DishAdapter(dishes)

        dishesRV.layoutManager = LinearLayoutManager(baseContext)
        dishesRV.adapter = adapter
    }
}
