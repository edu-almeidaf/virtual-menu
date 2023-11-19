package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.DishAdapter
import com.example.trybevirtualmenu.interfaces.DishItemListener
import com.example.trybevirtualmenu.models.DishDatabase

class MainActivity : AppCompatActivity(), DishItemListener {
    private val dishesRV: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dishes = DishDatabase.getDishes()
        val adapter = DishAdapter(dishes)
        adapter.setDishListener(this)

        dishesRV.layoutManager = LinearLayoutManager(baseContext)
        dishesRV.adapter = adapter
    }

    override fun onDishClick(view: View, position: Int) {
        val it = Intent(baseContext, MenuItemDetailActivity::class.java)
        it.putExtra("dish_id", position)
        startActivity(it)
    }
}
