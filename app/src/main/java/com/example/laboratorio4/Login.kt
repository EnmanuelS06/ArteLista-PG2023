package com.example.laboratorio4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnIniciarSesion:Button= findViewById(R.id.btnLogin)
        btnIniciarSesion.setOnClickListener { v ->
            val intent = Intent(v.context, MainActivity::class.java)
            startActivity(intent)
        }
        val tvcrearCuenta: TextView=findViewById(R.id.registrar)
        tvcrearCuenta.setOnClickListener{ v->
            val intent= Intent(v.context,activity_CrearCuenta::class.java)
            startActivity(intent)
        }
    }
}