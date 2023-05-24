package com.example.laboratorio4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio4.R
import com.example.laboratorio4.model.evento
import com.example.laboratorio4.ui.evento.EventoFragment
import com.example.laboratorio4.ui.evento.eventoListener


class adapterevento(val EventoListener: EventoFragment): RecyclerView.Adapter<adapterevento.EventoViewHolder>() {
   var listEvento = ArrayList<evento>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent, false)
        return EventoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val eventos : evento =listEvento[position]
        holder.tvTituloEvento.text = eventos.tituloEvento
        holder.tvHoraEvento.text = eventos.horaEvento
        holder.tvEventCategory.text = eventos.categoriaEvento
       holder.itemView.setOnClickListener{
            EventoListener.onEventoClicked(eventos,position)

        }

    }

    override fun getItemCount(): Int {
        return listEvento.size
    }
    fun updateData(data:List<evento>?){
        listEvento.clear()
        listEvento.addAll(data!!)
        notifyDataSetChanged()
    }
    inner class EventoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTituloEvento: TextView
        val tvHoraEvento : TextView
        val tvEventCategory: TextView

        init{
            tvTituloEvento=itemView.findViewById<View>(R.id.tvTituloEvento) as TextView
            tvHoraEvento = itemView.findViewById<View>(R.id.tvEventoHora) as TextView
            tvEventCategory = itemView.findViewById<View>(R.id.tvCategoriaEvento) as TextView
        }


    }
}