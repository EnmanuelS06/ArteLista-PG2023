package com.example.laboratorio4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratorio4.data.ICallback
import com.example.laboratorio4.data.serviceFirestore
import com.example.laboratorio4.model.evento

class EventoViewModel : ViewModel() {

    //----Inicializacion
    val firestoreservice = serviceFirestore()
    var listevento:MutableLiveData<List<evento>> = MutableLiveData()

    fun getEventoVwm(){
        firestoreservice.getevento(object :ICallback<List<evento>>{
            override fun onSuccess(result: List<evento>?) {
                listevento.postValue(result!!)
            }

            override fun onFailed(exception: Exception) {
                TODO("Not yet implemented")
            }
        })

        }


}