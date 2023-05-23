package com.example.laboratorio4.ui.galeria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio4.R
import com.example.laboratorio4.adapter.adaptergaleria
import com.example.laboratorio4.databinding.FragmentArteBinding
import com.example.laboratorio4.model.galeria
import com.example.laboratorio4.viewmodel.GaleriaViewModel

class GaleriaFragment : Fragment(), galeriaListener {

    private var _binding: FragmentArteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var galeriaAdapter:adaptergaleria
    private lateinit var vwmGaleria:GaleriaViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galeriaViewModel =
            ViewModelProvider(this).get(GaleriaViewModel::class.java)

        _binding = FragmentArteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //----
        vwmGaleria = ViewModelProvider(this).get(GaleriaViewModel::class.java)
        vwmGaleria.getGaleriaVWM()
        galeriaAdapter = adaptergaleria(this)
        //----
        binding.rvGaleria.apply {
            layoutManager= LinearLayoutManager(view?.context,LinearLayoutManager.VERTICAL,false)
            adapter = galeriaAdapter
        }
        observerViewModel()
        return root
    }

    fun observerViewModel(){
        vwmGaleria.listgaleria.observe( viewLifecycleOwner, Observer <List<galeria>>{ galeria->
            galeriaAdapter.updateData(galeria)
        })
    }

    override fun onGaleriaClicked(Galeria: galeria, position: Int) {
        val bundle = bundleOf("galeria"  to Galeria)
        NavHostFragment.findNavController(this).navigate(R.id.fragment_galeriadet, bundle)
       //super.onGaleriaClicked(Galeria, position)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}