package com.example.laboratorio4.ui.evento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio4.R
import com.example.laboratorio4.adapter.adapterevento
import com.example.laboratorio4.databinding.FragmentEventosBinding
import com.example.laboratorio4.model.evento
import com.example.laboratorio4.viewmodel.EventoViewModel
import java.text.FieldPosition

class EventoFragment : Fragment(), eventoListener {

    private var _binding: FragmentEventosBinding? = null
    private val binding get() = _binding!!

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var eventoadapter:adapterevento
    private lateinit var eventoVwm:EventoViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val eventoViewModel =
            ViewModelProvider(this).get(EventoViewModel::class.java)

        _binding = FragmentEventosBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //--------
        eventoVwm = ViewModelProvider(this).get(EventoViewModel::class.java)
        eventoVwm.getEventoVwm()
        eventoadapter = adapterevento(this)
       ///------
        binding.rvEvento.apply {
            layoutManager = LinearLayoutManager(view?.context,LinearLayoutManager.VERTICAL,false)
            adapter = eventoadapter
        }
        observerViewModel()
        return root
    }
    fun observerViewModel(){
        eventoVwm.listevento.observe(viewLifecycleOwner, Observer<List<evento>> {
            evento-> eventoadapter.updateData(evento)
        })
        eventoVwm.isLoad.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                binding.progressEvento.visibility = View.INVISIBLE
            }
        })
    }
    /*fun getEventos(): ArrayList<evento> {
        val evento: ArrayList<evento> = ArrayList<evento>()
        //-------------
        evento.add(evento("Armando Jose Aguirre", "Oil","08:00"))
        evento.add(evento("German Traña Obando", "Lapiz","10:00" ))
        evento.add(evento("Pol Ledent", "Acrilico", "03:00"))
        evento.add(evento("Maribel Flores", "Oleo","11:00" ))
        evento.add(evento("Nana Tchelidze", "Canva","04:00" ))
        return evento

    }*/
    override fun onEventoClicked(Evento:evento, position: Int){
        val bundle = bundleOf("evento" to Evento)
        NavHostFragment.findNavController(this).navigate(R.id.locationFragment,bundle)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}