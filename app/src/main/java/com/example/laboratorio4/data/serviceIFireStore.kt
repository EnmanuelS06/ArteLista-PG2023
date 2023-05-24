package com.example.laboratorio4.data

import com.example.laboratorio4.model.artista
import com.example.laboratorio4.model.galeria
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ktx.toObjects

//Nombre de las colecciones tal cual existen en Firebase
const val GALERIA_COLLECTION_NAME="Galeria"
const val ARTISTA_COLLECTION_NAME = "Artista"

class serviceFirestore  {
    //------------------
    val CloudFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().build()

    init{
        //Nos permite tener los datos offline
        CloudFirestore.firestoreSettings=settings

    }
    fun getartista(callback: ICallback<List<artista>>){
        CloudFirestore.collection(ARTISTA_COLLECTION_NAME).orderBy("categoriaArtista")
            .get().addOnSuccessListener { result ->
                for(doc in result){
                    val list= result.toObjects(artista::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getgaleria(callback: ICallback<List<galeria>>) {
        CloudFirestore.collection(GALERIA_COLLECTION_NAME)
            .orderBy("artistagaleria")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(galeria::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}
