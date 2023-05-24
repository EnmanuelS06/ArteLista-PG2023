package com.example.laboratorio4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratorio4.data.ICallback
import com.example.laboratorio4.data.serviceFirestore
import com.example.laboratorio4.model.galeria

class GaleriaViewModel : ViewModel() {

    //----Inicializacion
    val firestoreserivice =serviceFirestore()
    var listgaleria: MutableLiveData<List<galeria>> = MutableLiveData()
    var isLoad = MutableLiveData<Boolean>()
    //---GetGaleria
    fun getGaleriaVWM(){
        firestoreserivice.getgaleria(object : ICallback<List<galeria>>{
            override fun onSuccess(result: List<galeria>?) {
                listgaleria.postValue(result!!)
            }

            override fun onFailed(exception: Exception) {
                Iscargado()
            }
        })

    }

    fun Iscargado(){
        isLoad.value=true
    }

}