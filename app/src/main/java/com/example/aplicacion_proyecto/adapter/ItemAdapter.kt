package com.example.aplicacion_proyecto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacion_proyecto.R
import com.example.aplicacion_proyecto.model.Descriptions

class ItemAdapter (
    private val context: Context,
    private val dataset: List<Descriptions>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
            val textView: TextView = view.findViewById<TextView>(R.id.ivText)
            val imageView: ImageView = view.findViewById<ImageView>(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val adapterView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view,parent,false)
            return ItemViewHolder(adapterView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val view = dataset[position]
        holder.textView.text = context.resources.getString(view.stringResourceId)
        holder.imageView.setImageResource(view.drawableResourceId)
    }

    override fun getItemCount(): Int {
            return dataset.size
    }
}