package com.example.laboratorio4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratorio4.data.ICallback
import com.example.laboratorio4.data.serviceFirestore
import com.example.laboratorio4.model.artista
import com.example.laboratorio4.model.galeria

class ArtistaViewModel : ViewModel() {
    // Inicializacion
    val firestoreserivice = serviceFirestore()
    var listArtista: MutableLiveData<List<artista>> = MutableLiveData()

    fun getArtistaVwm(){
        firestoreserivice.getartista(object : ICallback<List<artista>> {
            override fun onSuccess(result: List<artista>?) {
                listArtista.postValue(result!!)
            }

            override fun onFailed(exception: Exception) {
                println("${exception.message}")
            }
        })
    }

}