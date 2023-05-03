package com.example.laboratorio4.ui.evento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.FragmentLocationBinding

//
class LocationFragment : Fragment() {


    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLocationBinding.inflate(inflater,container,false)
        val root: View=binding.root
        val img_map:ImageView=_binding!!.imgMap
        img_map.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.locationDetailsFragment)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}