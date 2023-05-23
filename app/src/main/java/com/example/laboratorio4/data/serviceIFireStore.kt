package com.example.laboratorio4.data

import com.example.laboratorio4.model.galeria
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

//Nombre de las colecciones tal cual existen en Firebase
const val GALERIA_COLLECTION_NAME="Galeria"

class serviceFirestore  {
    //------------------
    val CloudFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().build()

    init{
        //Nos permite tener los datos offline
        CloudFirestore.firestoreSettings=settings

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
