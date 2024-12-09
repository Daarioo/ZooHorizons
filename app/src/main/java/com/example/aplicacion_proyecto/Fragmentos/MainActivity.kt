package com.example.aplicacion_proyecto.Fragmentos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.aplicacion_proyecto.R
import com.example.aplicacion_proyecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Binding generado para activity_main.xml

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Inicializar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el controlador de navegación y la barra de navegación inferior
        val navController = findNavController(R.id.fragmentContainer)
        val bottomNav = binding.bottomNavigationView // Usando ViewBinding para acceder a la vista

        // Configurar la navegación
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_inicio -> {
                    navController.navigate(R.id.inicioFragment)
                    true
                }
                R.id.item_principal -> {
                    navController.navigate(R.id.principalFragment)
                    true
                }
                R.id.item_fichas -> {
                    navController.navigate(R.id.fichasFragment)
                    true
                }
                R.id.item_carrito -> {
                    navController.navigate(R.id.carritoFragment)
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) {
            navController.navigate(R.id.inicioFragment)
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}



