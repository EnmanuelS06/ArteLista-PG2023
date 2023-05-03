package com.example.laboratorio4.ui.galeria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.laboratorio4.databinding.FragmentGaleriadetBinding


class fragment_galeriadet : Fragment() {
    private var _binding:FragmentGaleriadetBinding?=null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentGaleriadetBinding.inflate(inflater, container,false)
       val view:View = binding.root
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}