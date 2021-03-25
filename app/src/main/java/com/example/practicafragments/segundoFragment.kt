package com.example.practicafragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.navArgs

class segundoFragment : Fragment(R.layout.fragment_segundo) {
    private var nombre: String? = ""
    private var edad: Int? = 0
    private val args: segundoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            nombre = args.nombre
            edad = args.edad


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txt_output)
        val button = view.findViewById<Button>(R.id.btn_enviar_datos)
        button.setOnClickListener{
            val result = "Resultado segundo Fragment"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
        text.text = "$nombre $edad"
    }

    companion object{
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        fun newInstance(nombre: String, edad: Int) = segundoFragment().apply {
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }
    }
}