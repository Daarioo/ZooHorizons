package com.example.aplicacion_proyecto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacion_proyecto.R
import com.example.aplicacion_proyecto.javaClasses.Mascota

class MascotaAdapter(
    private val mascotas: List<Mascota>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(mascota: Mascota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MascotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotas[position]
        holder.bind(mascota, listener)
    }

    override fun getItemCount(): Int = mascotas.size

    class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imagenMascota: ImageView = itemView.findViewById(R.id.ivImage)
        private val nombreMascota: TextView = itemView.findViewById(R.id.ivText)

        fun bind(mascota: Mascota, listener: OnItemClickListener) {
            imagenMascota.setImageResource(mascota.imagenId)
            nombreMascota.text = mascota.nombre
            itemView.setOnClickListener { listener.onItemClick(mascota) }
        }
    }
}