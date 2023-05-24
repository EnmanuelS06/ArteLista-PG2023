package com.example.laboratorio4.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio4.R
import com.example.laboratorio4.model.artista
import com.example.laboratorio4.ui.artista.artistaListener

class adapterArtista (val ArtistaListener:artistaListener): RecyclerView.Adapter<adapterArtista.ArtistaViewHolder>() {
     var Listartistas= ArrayList<artista>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ArtistaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_artista, parent, false)
        return ArtistaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistaViewHolder, position: Int) {
        val artistas:artista =Listartistas[position]
        holder.tvNombreArtista.text = artistas.NombreArtista
        holder.tvCategoriaArtista.text = artistas.categoriaArtista
        holder.tvPaisArtista.text = artistas.PaisArtista
       holder.itemView.setOnClickListener{
            ArtistaListener.OnArtistaClicked(artistas,position)
        }

    }

    override fun getItemCount(): Int {
        return Listartistas.size
    }
    fun updatedata(data:List<artista>?)
    {
        Listartistas.clear()
        Listartistas.addAll(data!!)
        notifyDataSetChanged()

    }

    inner class ArtistaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNombreArtista: TextView
        val tvCategoriaArtista : TextView
        val tvPaisArtista: TextView

        init{
            tvNombreArtista=itemView.findViewById<View>(R.id.tvNombreArtista) as TextView
            tvCategoriaArtista = itemView.findViewById<View>(R.id.tvCategoriaArtista) as TextView
            tvPaisArtista = itemView.findViewById<View>(R.id.tvPaisArtista) as TextView
        }


    }
}