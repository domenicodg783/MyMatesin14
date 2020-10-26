package com.example.mymatesin


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase


class UserRegistration : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userregistration)

        supportActionBar?.hide()

        var registerbutton = findViewById<Button>(R.id.confermaregistrazione)
        var numero = findViewById<EditText>(R.id.NumeroTelefono)
        var password = findViewById<EditText>(R.id.Password)
        var nome = findViewById<EditText>(R.id.Nome)
        var cognome = findViewById<EditText>(R.id.Cognome)
        var email = findViewById<EditText>(R.id.Mail)

        firebaseAuth = FirebaseAuth.getInstance()

        @Override
        fun onStart(){
            super.onStart()
            var currentUser : FirebaseUser? = firebaseAuth!!.currentUser


        }


    }
}

