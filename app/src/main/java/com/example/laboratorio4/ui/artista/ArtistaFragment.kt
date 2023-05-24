package com.example.laboratorio4.ui.artista

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio4.R
import com.example.laboratorio4.adapter.adapterArtista
import com.example.laboratorio4.databinding.FragmentArtistaBinding
import com.example.laboratorio4.model.artista
import com.example.laboratorio4.viewmodel.ArtistaViewModel


class ArtistaFragment : Fragment(),artistaListener {

    private  var _binding:FragmentArtistaBinding? = null
    private val binding get() = _binding!!

    //--------
    private lateinit var adapterArtista: adapterArtista
    private lateinit var artistaVwm: ArtistaViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val artistaViewModel=
            ViewModelProvider(this).get(ArtistaViewModel::class.java)
        _binding= FragmentArtistaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //----
            artistaVwm = ViewModelProvider(this).get(ArtistaViewModel::class.java)
            artistaVwm.getArtistaVwm()
            adapterArtista = adapterArtista(this)
       //--------
        binding.rvArtista.apply {
            layoutManager = LinearLayoutManager(view?.context,LinearLayoutManager.VERTICAL,false)
            adapter = adapterArtista
        }
        observerViewModel()
        return root
    }
    fun observerViewModel(){
        artistaVwm.listArtista.observe(viewLifecycleOwner, Observer<List<artista>>{
            artista-> adapterArtista.updatedata(artista)
        })
        artistaVwm.isLoad.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                binding.progressArtista.visibility = View.INVISIBLE
            }
        })
    }

    override fun OnArtistaClicked(Artista: artista, position: Int) {
        val bundle = bundleOf("artista" to Artista)
        NavHostFragment.findNavController(this).navigate(R.id.artistDetFragment,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}