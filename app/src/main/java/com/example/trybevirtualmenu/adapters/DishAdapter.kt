package com.example.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.interfaces.Dish
import com.example.trybevirtualmenu.interfaces.DishItemListener
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class DishAdapter(val dishes: List<Dish>) : Adapter<DishAdapter.DishViewHolder>() {
    private var dishListener: DishItemListener? = null

    fun setDishListener(listener: DishItemListener) {
        this.dishListener = listener
    }

    class DishViewHolder(view: View, dishListener: DishItemListener?) :
        RecyclerView.ViewHolder(view) {
        val image: ShapeableImageView = view.findViewById(R.id.item_menu_image)
        val name: MaterialTextView = view.findViewById(R.id.item_menu_name)

        init {
            view.setOnClickListener {
                dishListener?.onDishClick(view, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu_layout, parent, false)
        return DishViewHolder(view, dishListener)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.name.text = dishes[position].name
        holder.image.setImageResource(dishes[position].image)
    }

    override fun getItemCount(): Int = dishes.size
}
