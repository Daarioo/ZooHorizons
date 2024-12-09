package com.example.aplicacion_proyecto.Fragmentos

import android.R
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.aplicacion_proyecto.adapter.FichaAdapter
import com.example.aplicacion_proyecto.data.FichaDataSource
import com.example.aplicacion_proyecto.databinding.FragmentFichasBinding
import com.example.aplicacion_proyecto.databinding.VentanaEmergenteBinding
import com.example.aplicacion_proyecto.model.FichaAnimal


import androidx.recyclerview.widget.LinearLayoutManager
import java.util.Calendar


class FichasFragment : Fragment() {

    private var _binding: FragmentFichasBinding? = null
    private val binding get() = _binding!!

    private lateinit var fichaAdapter: FichaAdapter
    private lateinit var fichaDataSource: FichaDataSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFichasBinding.inflate(inflater, container, false)

        fichaDataSource = FichaDataSource()
        fichaAdapter = FichaAdapter(requireContext(), fichaDataSource.getFichaList())

        binding.recyclerViewFichas.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFichas.adapter = fichaAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            showAddPetDialog()
        }
    }

    private fun showAddPetDialog() {
        val popupBinding = VentanaEmergenteBinding.inflate(LayoutInflater.from(context))
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(popupBinding.root)
            .setTitle("Añadir Ficha de Mascota")
        val alertDialog = dialogBuilder.show()

        val animalTypes = listOf("Roedores", "Perros", "Gatos", "Pájaros", "Reptiles", "Peces")
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, animalTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        popupBinding.spinnerPetType.adapter = adapter

        popupBinding.etAdoptionDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, selectedYear, selectedMonth, selectedDay ->
                    val formattedDate = "%02d/%02d/%04d".format(selectedDay, selectedMonth + 1, selectedYear)
                    popupBinding.etAdoptionDate.setText(formattedDate)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        popupBinding.btnAddPet.setOnClickListener {
            val name = popupBinding.etPetName.text.toString()
            val type = popupBinding.spinnerPetType.selectedItem.toString()
            val date = popupBinding.etAdoptionDate.text.toString()

            if (name.isNotEmpty() && type.isNotEmpty() && date.isNotEmpty()) {
                val ficha = FichaAnimal(name, type, date)

                fichaDataSource.addFicha(ficha)
                fichaAdapter.agregarFicha(ficha)
                fichaAdapter.notifyDataSetChanged()

                alertDialog.dismiss()

                popupBinding.etPetName.text.clear()
                popupBinding.etAdoptionDate.text.clear()

                Toast.makeText(context, "Ficha añadida: $name, $type, $date", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
