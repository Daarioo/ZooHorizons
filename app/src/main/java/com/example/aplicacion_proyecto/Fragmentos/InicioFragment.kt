package com.example.aplicacion_proyecto.Fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aplicacion_proyecto.InicioSesion.Usuario
import com.example.aplicacion_proyecto.InicioSesion.UsuarioDao
import com.example.aplicacion_proyecto.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class InicioFragment : Fragment() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var userDAO: UsuarioDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)

        usernameEditText = view.findViewById(R.id.loginUsername)
        passwordEditText = view.findViewById(R.id.loginPassword)
        loginButton = view.findViewById(R.id.BtnGetStart)

        userDAO = UsuarioDao(requireContext())

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userDAO.isUserExists(username)) {
                if (userDAO.authenticateUser(username, password)) {
                    Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_inicioFragment_to_principalFragment)
                } else {
                    Toast.makeText(requireContext(), "Incorrect password", Toast.LENGTH_SHORT).show()
                }
            } else {
                userDAO.insertUser(Usuario(username, password))
                Toast.makeText(requireContext(), "User created", Toast.LENGTH_SHORT).show()

                findNavController().navigate(R.id.action_inicioFragment_to_principalFragment)
            }
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView?.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView?.visibility = View.VISIBLE
    }
}
