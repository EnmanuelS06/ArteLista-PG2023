package com.example.laboratorio4.ui.artista

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.laboratorio4.databinding.FragmentArtistaBinding

class ArtistaFragment : Fragment() {

    private  var _binding:FragmentArtistaBinding? = null
    private val binding get() = _binding!!
   /* companion object {
        fun newInstance() = ArtistaFragment()
    }*/

   /* private lateinit var viewModel: ArtistaViewModel*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val artistaViewModel= ViewModelProvider(this).get(ArtistaViewModel::class.java)
        _binding= FragmentArtistaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
        /*return inflater.inflate(R.layout.fragment_artista, container, false)*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArtistaViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}