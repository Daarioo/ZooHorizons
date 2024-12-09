package com.example.aplicacion_proyecto.Fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacion_proyecto.R
import com.example.aplicacion_proyecto.adapter.MascotaAdapter
import com.example.aplicacion_proyecto.javaClasses.Mascota

@Suppress("DEPRECATION")
class PrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_principal, container, false)

        val mascotas = listOf(
            Mascota("Perros", R.drawable.image1),
            Mascota("Gatos", R.drawable.image3),
            Mascota("Roedores", R.drawable.image6),
            Mascota("Peces", R.drawable.image2),
            Mascota("Réptiles", R.drawable.image5),
            Mascota("Aves", R.drawable.image4)
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val adapter = MascotaAdapter(mascotas, object : MascotaAdapter.OnItemClickListener {
            override fun onItemClick(mascota: Mascota) {
                Toast.makeText(context, "Mascota seleccionada: ${mascota.nombre}", Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.setHasFixedSize(true)

        return view
    }

}
