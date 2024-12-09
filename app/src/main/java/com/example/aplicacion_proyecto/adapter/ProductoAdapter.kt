package com.example.aplicacion_proyecto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacion_proyecto.R
import com.example.aplicacion_proyecto.javaClasses.Producto

class ProductoAdapter(
    private val productos: List<Producto>,
    private val onItemClick: (Producto) -> Unit
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.bind(producto, onItemClick)
    }

    override fun getItemCount() = productos.size

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.tvTituloProductos)
        private val precioTextView: TextView = itemView.findViewById(R.id.recyclerProductos)

        fun bind(producto: Producto, onItemClick: (Producto) -> Unit) {
            nombreTextView.text = producto.nombre
            precioTextView.text = "€${producto.precio}"
            itemView.setOnClickListener { onItemClick(producto) }
        }
    }
}