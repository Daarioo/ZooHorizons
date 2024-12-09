package com.example.aplicacion_proyecto.Fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicacion_proyecto.adapter.ProductoAdapter
import com.example.aplicacion_proyecto.databinding.FragmentProductBinding
import com.example.aplicacion_proyecto.javaClasses.Producto

class ProductFragment : Fragment() {

    companion object {
        private const val ARG_MASCOTA = "mascota"

        fun newInstance(tipoMascota: String): ProductFragment {
            val fragment = ProductFragment()
            val args = Bundle().apply {
                putString(ARG_MASCOTA, tipoMascota)
            }
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tipoMascota = arguments?.getString(ARG_MASCOTA) ?: ""
        val productos = getProductosParaMascota(tipoMascota)

        // Configuración del RecyclerView
        binding.recyclerProductos.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ProductoAdapter(productos) { producto ->
                Toast.makeText(requireContext(), "Producto seleccionado: ${producto.nombre}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getProductosParaMascota(tipoMascota: String): List<Producto> {
        val productos = mutableListOf<Producto>()
        when (tipoMascota) {
            "Perro" -> {
                productos.add(Producto("Juguete mordedor", 10.99))
                productos.add(Producto("Comida premium", 25.49))
            }
            "Gato" -> {
                productos.add(Producto("Rascador", 19.99))
                productos.add(Producto("Arena", 5.49))
            }
        }
        return productos
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

