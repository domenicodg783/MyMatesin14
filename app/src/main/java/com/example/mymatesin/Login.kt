package com.example.mymatesin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val registerbutton = findViewById<Button>(R.id.registrati)

        registerbutton.setOnClickListener {
            val intent = Intent(this@Login, UserRegistration::class.java)
            startActivity(intent)
        }
    }
}


