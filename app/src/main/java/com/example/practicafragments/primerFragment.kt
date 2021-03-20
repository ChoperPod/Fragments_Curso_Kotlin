package com.example.practicafragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

class primerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_nav)
        val resultado = view.findViewById<TextView>(R.id.txt_output)

        setFragmentResultListener("requestKey") { Key, bundle ->
            val result = bundle.getString("bundleKey")
            resultado.text = result
        }

        button.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                // add(R.id.fragment_container_view,segundoFragment())//agrega fragmentos encima
                replace(R.id.fragment_container_view, segundoFragment.newInstance("Alfredo", 27))// reemplaza fragmentos encima del anterior
                addToBackStack("primerFragment")
            }
        }
    }
}
