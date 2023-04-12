package com.example.laboratorio4


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import java.lang.Exception

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
       try {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_splashscreen)

           val LogoApp:ImageView = findViewById(R.id.imgartelista)
           val AnimLogo:Animation= AnimationUtils.loadAnimation(this, R.anim.anim1)
           LogoApp.startAnimation(AnimLogo)


           val intent = Intent(this, Login::class.java)
           AnimLogo.setAnimationListener(object: Animation.AnimationListener{
               override fun onAnimationStart(p0: Animation?) {
               }

               override fun onAnimationEnd(p0: Animation?) {
                   startActivity(intent)
                   finish()
               }

               override fun onAnimationRepeat(p0: Animation?) {
               }
           })
       }catch (e: Exception){
           e.printStackTrace()
       }

    }
}